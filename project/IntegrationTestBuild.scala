import sbt._
import Keys._

object IntegrationTestBuild extends Build {
  lazy val root =
    Project("root", file("."))
        .configs(IntegrationTest)
        .settings(Defaults.itSettings: _*)
        .settings(libraryDependencies += specs)

  lazy val specs = "org.scalatest" % "scalatest_2.10" % "2.0.RC2" % "it,test"
}