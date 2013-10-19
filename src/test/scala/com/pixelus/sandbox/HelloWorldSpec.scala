package com.pixelus.sandbox

import org.scalatest._
import collection.mutable.Stack

class HelloWorldSpec extends FlatSpec with ShouldMatchers with OptionValues with Inside {

  "Saying hello" should "greet me by name" in {
    HelloWorld.sayHello("Dave") should be ("Hello Dave!")
  }

}
