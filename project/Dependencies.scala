import sbt._

object Dependencies {

  object Versions {
    val Cats = "1.0.1"
    val Joda = "2.10.3"

    val Emoji = "1.2.1"

    val ScalaTest = "3.0.8"
  }

  val cats: ModuleID = "org.typelevel" %% "cats-core" % Versions.Cats
  val joda: ModuleID = "joda-time"     % "joda-time"  % Versions.Joda

  val emoji: ModuleID = "com.lightbend" %% "emoji" % Versions.Emoji

  val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.ScalaTest % "test"

}
