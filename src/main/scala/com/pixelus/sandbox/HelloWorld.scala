package com.pixelus.sandbox

object HelloWorld {

  def sayHello(name:String): String = {
    s"Hello ${name}!";
  }

  def main(args:Array[String]) = {
    var name = if (args.length > 0) args(1) else "Dave";

    println(sayHello(name))
  }
}

//HelloWorld.sayHello("Dave")