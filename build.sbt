import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "holiday",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "holiday",
    libraryDependencies ++= Seq(
      scalaTest % Test
    )
  )
