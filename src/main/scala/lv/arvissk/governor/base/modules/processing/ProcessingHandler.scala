/*
* Sets up various processing tasks that can process incoming sensor data and store it accordingly.
*/
package lv.arvissk.governor.base.modules.processing

import akka.actor._
import lv.arvissk.governor.base.modules.ModuleProtocol.ModuleStartupSuccessCallback

object ProcessingHandler {

  def props: Props = Props[ProcessingHandler]

  case object InitProcessing

  case object ShutdownProcessing

}

class ProcessingHandler() extends Actor {

  import ProcessingHandler._

  def receive = {
    case InitProcessing =>
      context.parent ! ModuleStartupSuccessCallback("processing")

    case ShutdownProcessing =>

  }

}
