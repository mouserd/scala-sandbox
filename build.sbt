name := "scala-sandbox"

version := "1.0.0"

scalaVersion := "2.10.3"

// Dependencies
libraryDependencies ++= Seq(
    "org.apache.httpcomponents" % "httpclient"                    % "4.3.1",
    // The %% is shorthand to automatically add the version of scala to the artifactId (e.g. casbah_2.10)
    "org.mongodb"               %% "casbah"                       % "2.6.3",
    "javax.servlet"             % "javax.servlet-api"             % "3.0.1"               % "provided",
    "org.eclipse.jetty.orbit"   % "javax.servlet"                 % "3.0.0.v201112011016" % "provided"    artifacts Artifact("javax.servlet", "jar", "jar"),
    "org.eclipse.jetty"         % "jetty-webapp"                  % "8.1.5.v20120716"     % "container",
    "org.scalatest"             % "scalatest_2.10"                % "2.0.RC2"             % "test",
     "org.mockito"              % "mockito-core"                  % "1.9.0"               % "test"
)

classpathTypes ~= (_ + "orbit")

seq(webSettings :_*)

seq(ScctPlugin.instrumentSettings : _*)

// ScalaStyle settings
org.scalastyle.sbt.ScalastylePlugin.Settings

// Jetty settings
port in container.Configuration := 8081