name := "JFS_SCALA"

organization := "br.com.rcbs"

version := "1.0-SNAPSHOT"

description := "Cessão de Recebíveis - Minimização de Perdas"

publishMavenStyle := true

crossPaths := false

autoScalaLibrary := true

libraryDependencies ++= Seq(
   "org.apache.commons" % "commons-math3" % "3.1.1",
   "org.fluentd" % "fluent-logger" % "0.2.10",
   "org.mockito" % "mockito-core" % "1.9.5" % "test"  
)
