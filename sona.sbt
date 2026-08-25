lazy val developer1 = Developer(
  id = "djx314",
  name = "djx314",
  email = "djx314@sina.cn",
  url = uri("https://github.com/djx314")
)

ThisBuild / version              := "0.0.2-M29"
ThisBuild / organization         := "net.scalax.simple"
ThisBuild / organizationName     := "Scalax"
ThisBuild / organizationHomepage := Some(uri("https://github.com/scalax"))
ThisBuild / scmInfo              := Some(
  ScmInfo(
    uri("https://github.com/scalax/simple-adt"),
    "scm:git@github.com:scalax/simple-adt.git"
  )
)
ThisBuild / developers           := List(developer1)
ThisBuild / description          := "Simple, and scalable. Use it to subvert the author's imagination."
ThisBuild / licenses             := List(License("MIT License", uri("https://github.com/scalax/simple-codec/blob/main/LICENSE")))
ThisBuild / homepage             := Some(uri("https://github.com/scalax/simple-codec"))
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishMavenStyle    := true
ThisBuild / versionScheme        := Some("early-semver")
