ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "scalasample"
  )

libraryDependencies ++= Seq(
  "org.apache.pekko" %% "pekko-http" % "1.0.1", // Pekko HTTP
  "org.apache.pekko" %% "pekko-actor" % "1.0.3",
  "org.apache.pekko" %% "pekko-stream" % "1.0.3",
  "org.apache.pekko" %% "pekko-http-spray-json" % "1.0.1",
  "org.slf4j" % "slf4j-simple" % "2.0.13",
  "org.wvlet.airframe" %% "airframe" % "24.5.1" // Airframe DI
)

resolvers += "Apache Pekko Repository" at "https://repository.apache.org/content/repositories/releases/"
