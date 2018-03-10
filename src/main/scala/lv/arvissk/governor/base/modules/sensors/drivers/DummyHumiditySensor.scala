/**
  * Dummy temperature like sensor reading stream for testing
  **/
package lv.arvissk.governor.base.modules.sensors.drivers

import akka.actor._
import akka.stream._
import akka.stream.scaladsl._
import scala.concurrent._
import scala.concurrent.duration._
import scala.util.Random
import lv.arvissk.governor.base.modules.sensors.SensorsProtocol

object DummyHumiditySensor {

  def props(sensorName: String): Props = Props(new DummyHumiditySensor(sensorName: String))

}

class DummyHumiditySensor(sensorName: String) extends Actor {

  import SensorsProtocol._


  def receive = {
    case InitSensor =>
      sender ! SensorInitSuccessful(sensorName)
      pushDataUpstream(sender)
  }

  def sensorPushSink(sender: ActorRef) =
    Flow[TimestampedReading]
      .buffer(1, OverflowStrategy.dropBuffer)
      .delay(1 seconds, DelayOverflowStrategy.backpressure)
      .to(Sink.foreach(e => sender ! PushInitializedSensorDataToLog(e)))

  def randomIntSource =
    Source.fromIterator(() => Iterator.continually(Random.nextInt(35)))

  def throttlingFlow = Flow[Int].throttle(
    elements = 1,
    per = 1.second,
    maximumBurst = 0,
    mode = ThrottleMode.Shaping
  )

  def processStream =
    Flow[Int]
      .map { e =>
        TimestampedReading("humidity", e, System.currentTimeMillis(), sensorName)
      }

  def pushDataUpstream(sender: ActorRef): Unit = {
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    randomIntSource
      .via(throttlingFlow)
      .via(processStream)
      .to(sensorPushSink(sender))
      .run()
  }

}