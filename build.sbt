scalaVersion := "2.11.8"

name := "JFS_SCALA"

organization := "br.com.rcbs"

version := "1.0-SNAPSHOT"

// set the main class for the main 'sbt run' task
mainClass in (Compile, run) := Some("br.com.rcbs.Recevables")

description := "Assignment of Receivables - Minimization of Losses"

publishMavenStyle := true

crossPaths := false

autoScalaLibrary := true

libraryDependencies ++= Seq(
   "org.apache.commons" % "commons-math3" % "3.1.1",
   "org.fluentd" % "fluent-logger" % "0.2.10",
   "org.mockito" % "mockito-core" % "1.9.5" % "test"  
)
