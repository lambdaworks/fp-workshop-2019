import Dependencies._

lazy val buildSettings = Seq(
  organization := "io.lambdaworks",
  organizationName := "Lambdaworks",
  name := "Workshop",
  scalaVersion := "2.12.6",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Ypartial-unification")
)

lazy val libs = Seq(cats, joda, scalaTest)

lazy val root = (project in file("."))
  .settings(buildSettings: _*)
  .settings(libraryDependencies ++= libs)
