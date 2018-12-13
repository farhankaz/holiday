import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "io.scholiday",
      scalaVersion := "2.12.7",
      version      := "0.0.1"
    )),
    name := "scholiday",
    libraryDependencies ++= Seq(
      scalaTest % Test
    )
  )
