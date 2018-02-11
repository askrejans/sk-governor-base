name := "sk-governor-base"

version := "0.1"

scalaVersion := "2.12.4"

lazy val akkaVersion = "2.5.9"

resolvers += Resolver.bintrayRepo("cakesolutions", "maven")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % "2.5.9",
  "net.cakesolutions" %% "scala-kafka-client" % "1.0.0",
  "net.cakesolutions" %% "scala-kafka-client-akka" % "1.0.0",
  "net.cakesolutions" %% "scala-kafka-client-testkit" % "1.0.0" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.25",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "test",
  "com.typesafe.play" %% "play-json" % "2.6.8"
)
