package com.pixelus.sandbox.functions

object SampleFunctions {

  def addOne(num:Int):Int = num + 1

  def addOneWithNestedFunction(num:Int) = {
    def ++ = (x:Int) => x + 1
    ++(num)
  }
}
