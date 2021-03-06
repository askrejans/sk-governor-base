enablePlugins(JavaAppPackaging)

name := "sk-governor-base"

version := "0.1"

maintainer := "Arvis Skrējāns <arvis.skrejans@gmail.com>"

packageSummary := "SK Governor base system for sensor data logging"

packageDescription := "Platform for various sensor data logging and pushing to Elasticsearch with Kafka. This is the base package daemon for all backend services."

debianNativeBuildOptions in Debian := Nil

debianNativeBuildOptions in Debian := Seq("-Zgzip", "-z3")

scalaVersion := "2.12.4"

lazy val akkaVersion = "2.5.9"

val elastic4sVersion = "6.1.4"

resolvers += Resolver.bintrayRepo("cakesolutions", "maven")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % "2.5.9",
  "com.typesafe.akka" %% "akka-http" % "10.1.0",
  "net.cakesolutions" %% "scala-kafka-client" % "1.0.0",
  "net.cakesolutions" %% "scala-kafka-client-akka" % "1.0.0",
  "net.cakesolutions" %% "scala-kafka-client-testkit" % "1.0.0" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.25",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "test",
  "com.typesafe.play" %% "play-json" % "2.6.8",
  "com.sksamuel.elastic4s" %% "elastic4s-core" % elastic4sVersion,
  "com.sksamuel.elastic4s" %% "elastic4s-http" % elastic4sVersion,
  "com.sksamuel.elastic4s" %% "elastic4s-testkit" % elastic4sVersion % "test",
  "com.sksamuel.elastic4s" %% "elastic4s-embedded" % elastic4sVersion % "test",
  "com.github.nscala-time" %% "nscala-time" % "2.18.0",
  "com.github.pureconfig" %% "pureconfig" % "0.9.0",
  "net.liftweb" %% "lift-json" % "3.2.0"
)
