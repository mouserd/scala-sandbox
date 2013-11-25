package com.pixelus.sandbox.functions

object SampleFunctions {

  def addOne(num: Int): Int = num + 1

  def addOneWithNestedFunction(num: Int) = {
    def ++ = (x: Int) => x + 1
    ++(num)
  }

  def map[A, B](xs: List[A], f:A => B): List[B] = {
    xs match {
      case List() => Nil
      case head :: tail => f(head) :: map(tail, f)
    }
  }

  def map1[A, B](xs: List[A],f: A => B): List[B] = for (x <- xs) yield f(x)
}
