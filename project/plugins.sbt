resolvers += Classpaths.typesafeResolver

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

// IntelliJ project generation
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")

// Web plugin - jetty
addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.4.2")

// Code coverage
addSbtPlugin("reaktor" % "sbt-scct" % "0.2-SNAPSHOT")

// Scala style
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")

// Code stats
addSbtPlugin("com.orrsella" % "sbt-stats" % "1.0.5")