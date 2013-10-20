resolvers += Classpaths.typesafeResolver

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")

addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.4.2")

addSbtPlugin("reaktor" % "sbt-scct" % "0.2-SNAPSHOT")