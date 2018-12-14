import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "io.github.farhankaz",
      scalaVersion := "2.12.7",
      version      := "0.0.1"
    )),
    name := "scholiday",
    testFrameworks += new TestFramework("utest.runner.Framework"),
    libraryDependencies ++= Seq(
      uTest % Test
    )
  )
