import Dependencies._
import xerial.sbt.Sonatype._

organization := "io.github.farhankaz"
scalaVersion := "2.12.7"
version      := "0.0.1"
name := "scholiday"
publishTo := sonatypePublishTo.value

testFrameworks += new TestFramework("utest.runner.Framework")
libraryDependencies ++= Seq(
  uTest % Test
)
pgpSecretRing := Path.userHome / ".gnupg/pubring.kbx"
credentials += Credentials(Path.userHome / ".sbt" / "pgp.credentials")
useGpg := true

lazy val scholiday = (project in file("."))