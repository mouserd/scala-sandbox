package com.pixelus.sandbox

import org.scalatest._

class HelloWorldSpec extends FunSuite {

//  "Saying hello" should "greet me by name" in {
//    HelloWorld.sayHello("Dave") should be ("Hello Dave!")
//  }

  test("say hello should greet me by name") {
    assert(HelloWorld.sayHello("Dave") == "Hello Dave!")
  }
}
