import Dependencies._

ThisBuild / scalaVersion := "2.13.6"

lazy val compilerOptions = Seq(
  "-encoding",
  "UTF-8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  // "-Xfatal-warnings",
  "-Xlint",
  "-Wunused:imports,params"
)

lazy val root = (project in file("."))
  .aggregate(exercises, answers)
  .settings(
    name := "fpinscala"
  )

lazy val exercises = (project in file("exercises"))
  .settings(
    name := "exercises",
    scalacOptions := compilerOptions,
    scalafmtOnCompile := true,
    libraryDependencies := Seq(
      scalactic,
      scalatest % Test
    ),
    wartremoverWarnings ++= Warts.all
  )

lazy val answers = (project in file("answers"))
  .settings(
    name := "answers"
  )
