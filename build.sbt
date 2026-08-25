scalaVersion := scalaV.v213

lazy val codegen = (project in (file("") / "codegen"))
  .enablePlugins(SbtTwirl)
  .settings(scalaVersion := scalaV.v213, libraryDependencies ++= libScalax.`os-lib`.value, scalafmtOnCompile := true)

lazy val nat = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("") / "nat")
  .settings(
    scalaVersion       := scalaV.v213,
    crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3),
    scalafmtOnCompile  := true,
    publishTo          := localStaging.value,
    name               := "simple-codec-nat",
    libraryDependencies ++= libScalax.`scalatest`.value.map(_ % Test),
    libraryDependencies ++= libScalax.`simple-induction`.value,
    libraryDependencies ++= libScalax.`shapeless`.value,
    useKindProjector,
      scalafmtOnCompile:=true
  )

lazy val codec = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("") / "codec")
  .settings(
    scalaVersion       := scalaV.v213,
    crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3),
    scalafmtOnCompile  := true,
    publishTo          := localStaging.value,
    name               := "simple-codec",
    libraryDependencies ++= libScalax.`scalatest`.value.map(_ % Test),
    libraryDependencies ++= libScalax.`magnolia1.scala2`.value,
    libraryDependencies ++= libScalax.`magnolia1.scala3`.value,
    libraryDependencies ++= libScalax.`scala-compiler`.value,
    libraryDependencies ++= libScalax.`scala-collection-compat`.value,
    useKindProjector,
      scalafmtOnCompile:=true
  )
  .dependsOn(nat)

lazy val json = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("") / "json")
  .settings(
    scalaVersion       := scalaV.v213,
    crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3),
    scalafmtOnCompile  := true,
    publishTo          := localStaging.value,
    name               := "simple-codec-json",
    libraryDependencies ++= libScalax.`scalatest`.value.map(_ % Test),
    libraryDependencies ++= libScalax.`circe`.value,
    libraryDependencies ++= libScalax.`play-json`.value,
    libraryDependencies ++= libScalax.`circe-extras`.value,
    useKindProjector,
      scalafmtOnCompile:=true
  )
  .dependsOn(codec)

lazy val config = project
  .in(file("") / "config")
  .settings(
    scalaVersion       := scalaV.v213,
    crossScalaVersions := Seq(scalaV.v213, scalaV.v3),
    scalafmtOnCompile  := true,
    publishTo          := localStaging.value,
    name               := "simple-codec-config",
    libraryDependencies ++= libScalax.`scalatest`.value.map(_ % Test),
    libraryDependencies ++= libScalax.`pureconfig`.value,
    useKindProjector,
      scalafmtOnCompile:=true
  )
  .dependsOn(codec.jvm)

val slick = project
  .in(file("") / "slick")
  .settings(
    scalaVersion       := scalaV.v213,
    crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3),
    scalafmtOnCompile  := true,
    publishTo          := localStaging.value,
    name               := "simple-codec-slick",
    libraryDependencies ++= libScalax.`scalatest`.value.map(_ % Test),
    libraryDependencies ++= libScalax.`slick`.value,
    libraryDependencies ++= libScalax.`h2`.value,
    useKindProjector,
      scalafmtOnCompile:=true
  )
  .dependsOn(codec.jvm)
