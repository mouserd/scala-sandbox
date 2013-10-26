## Scala Sandbox

This is a project for learning and experimenting with Scala.

#### Included SBT Plugins

##### IntelliJ - [https://github.com/mpeltonen/sbt-idea](https://github.com/mpeltonen/sbt-idea)
* Create Project

```
sbt> gen-idea
```

##### Web Plugin - [https://github.com/JamesEarlDouglas/xsbt-web-plugin](https://github.com/JamesEarlDouglas/xsbt-web-plugin)
* Start local jetty:

```
sbt> container:start
```

* Stop local jetty:

```
sbt> container:stop
```

##### Scala Code Coverage Tool (scct) - [http://mtkopone.github.io/scct/](http://mtkopone.github.io/scct/)
* Run code coverage (outputs results to <code>./target/scala_2.10.3/coverage-report/index.html</code>):

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

##### sbt-stats - [https://github.com/orrsella/sbt-stats](https://github.com/orrsella/sbt-stats)
* View code stats
```
sbt> stats
```

#### REST Client
The REST client is a simple client for transmitting RESTful calls to a locally running RESTful server.

The RESTful server can be started by running <code>container:start</code> from SBT. You can then make
GET/PUT/POST/DELETE/OPTIONS requests to this server by running the REST client from SBT:

When executing the client, you can pass <code>-d</code> and/or <code>-h</code> argument that represents
request parameters or headers respectively that should be sent by the client to the server.  You can send
multiple parameters or headers by comma-separating them.

* GET request:
```
sbt> run-main RestClient get -h Request-Originator=RestfulClient -d refresh=true http://localhost:8081/
```
* PUT request:
```
sbt> run-main RestClient put -h Request-Originator=RestfulClient -d id=1,name=Dave http://localhost:8081/
```

* POST request:
```
sbt> run-main RestClient post -h Request-Originator=RestfulClient -d id=1,name=Dave http://localhost:8081/
```
* DELETE request:
```
sbt> run-main RestClient delete http://localhost:8081/
```
* OPTIONS request:
```
sbt> run-main RestClient options -h Request-Originator=RestfulClient http://localhost:8081/
```

If the server is setup correctly it should echo back a response that indicates:
 1. the method called
 2. any request parameters received, and
 3. any headers received.
