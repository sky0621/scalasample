ThisBuild / scalaVersion := "2.13.10"

libraryDependencies ++= Seq(
  // Apache Pekko HTTP
  "org.apache.pekko" %% "pekko-http" % "1.0.1",
  // Pekko ActorとStream（Pekko HTTPに必要）
  "org.apache.pekko" %% "pekko-actor" % "1.0.3",
  "org.apache.pekko" %% "pekko-stream" % "1.0.3",
  // Slick
  "com.typesafe.slick" %% "slick" % "3.5.2",
  // HikariCP（コネクションプール用）
  "com.typesafe.slick" %% "slick-hikaricp" % "3.5.2",
  // MySQL Connector/J
  "mysql" % "mysql-connector-java" % "8.0.33",
  // Airframe DI
  "org.wvlet.airframe" %% "airframe" % "24.9.3",
  // Spray JSON（JSONシリアライゼーション用）
  "io.spray" %% "spray-json" % "1.3.6",
  // Pekko HTTP Spray JSONサポート
  "org.apache.pekko" %% "pekko-http-spray-json" % "1.0.1",
  // ロギング用（Logback）
  "ch.qos.logback" % "logback-classic" % "1.5.6"
)

// Apache Pekkoのリゾルバを追加
resolvers += "Apache Pekko Repository" at "https://repository.apache.org/content/repositories/releases/"

// その他の設定（オプション）
scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-encoding",
  "utf8"
)
