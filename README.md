## Scala Sandbox

This is a project for learning and experimenting with Scala.

#### Useful SBT commands

##### IntelliJ
* Create Project

```
sbt> gen-idea
```

##### Jetty
* Start local jetty:

```
sbt> container:start
```

* Stop local jetty:

```
sbt> container:stop
```

##### Scala Code Coverage Tool (scct) - [http://mtkopone.github.io/scct/](http://mtkopone.github.io/scct/)
* Run code coverage (outputs results to ./target/scala_2.10.3/coverage-report/index.html):

```
sbt> scct:test
```

##### ScalaStyle - [https://github.com/scalastyle/scalastyle-sbt-plugin](https://github.com/scalastyle/scalastyle-sbt-plugin)
* Run ScalaStyle checks

```
sbt> scalastyle
```

* Generate default ScalaStyle configuration

```
sbt> scalastyle-generate-config
```

