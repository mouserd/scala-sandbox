resolvers += Classpaths.typesafeResolver

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += Classpaths.sbtPluginReleases

// IntelliJ project generation
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")

// Web plugin - jetty
addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.4.2")

// Code coverage
addSbtPlugin("com.github.scct" % "sbt-scct" % "0.2.1")

// Scala style
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")

// Code stats
addSbtPlugin("com.orrsella" % "sbt-stats" % "1.0.5")

// Growl Notify
addSbtPlugin("me.lessis" % "sbt-growl-plugin" % "0.1.3")
