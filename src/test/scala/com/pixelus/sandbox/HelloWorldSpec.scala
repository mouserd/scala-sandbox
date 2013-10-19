package com.pixelus.sandbox

class HelloWorldSpec extends BaseTest {

//  "Saying hello" should "greet me by name" in {
//    HelloWorld.sayHello("Dave") should be ("Hello Dave!")
//  }
  var hello:HelloWorld = _;

  before {
    hello = new HelloWorld
  }

  test("say hello should greet me by name") {
    hello.sayHello("Dave") should be ("Hello Dave!")
  }
}
