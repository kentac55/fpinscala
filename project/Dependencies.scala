import sbt._

object Dependencies {
  private val scalatestV = "3.2.10"

  val scalactic = "org.scalactic" %% "scalactic" % scalatestV
  val scalatest = "org.scalatest" %% "scalatest" % scalatestV
}
