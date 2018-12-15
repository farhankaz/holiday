// Your profile name of the sonatype account. The default is the same with the organization value

sonatypeProfileName := "io.github.farhankaz"
// To sync with Maven central, you need to supply the following information:
publishMavenStyle := true

// License of your choice
licenses := Seq("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))

// Where is the source code hosted
import xerial.sbt.Sonatype._
publishTo := sonatypePublishTo.value
sonatypeProjectHosting := Some(GitHubHosting("farhankaz", "scholiday", "farhan.kazmi@gmail.com"))

// or if you want to set these fields manually
homepage := Some(url("https://github.com/farhankaz/scholiday"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/farhankaz/scholiday"),
    "scm:git@github.com:farhankaz/(scholiday.git"
  )
)
developers := List(
  Developer(id="farhankaz", name="farhankaz", email="farhankaz2018@gmail.com", url=url("https://github.com/farhankaz"))
)