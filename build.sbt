name := "http-spray"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  // Spray
  "io.spray" % "spray-http_2.11" % "1.3.3",
  "io.spray" % "spray-can_2.11" % "1.3.3",
  "com.typesafe.akka" %% "akka-actor" % "2.4.0"
)
