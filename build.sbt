name := "Test Project"
version := "0.1-SNAPSHOT"
organization := "org.example"
scalaVersion in ThisBuild := "2.11.7"

libraryDependencies ++= Seq(
  "org.json4s" % "json4s-native_2.11" % "3.5.0"
)
