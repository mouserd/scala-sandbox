package com.pixelus.sandbox.functions

class SampleFunctions {

  def addOne(num: Int): Int = num + 1

  def addOneWithNestedFunction(num: Int) = {
    def ++ = (x: Int) => x + 1
    ++(num)
  }

  def mapWithMatchers[A, B](xs: List[A], f:A => B): List[B] = {
    xs match {
      case List() => Nil
      case head :: tail => f(head) :: mapWithMatchers(tail, f)
    }
  }

  def mapWithForComprehension[A, B](xs: List[A],f: A => B): List[B] = for (x <- xs) yield f(x)

  def multiplierForPartialFunction(a:Int, b:Int): Int = {
    a * b
  }

  val doublerPartial = multiplierForPartialFunction(2, _:Int)

  def multiplierForCurriedFunction(a:Int)(b:Int): Int = {
    a * b
  }

  val doublerCurried = multiplierForCurriedFunction(2) _

  def capitalizeVarArgs(strings: String*) = {
    strings.map { string =>
      string.toUpperCase
    }
  }
}

object SampleFunctions {
  def apply() = new SampleFunctions
}
