package com.pixelus.sandbox.parameterization

class Parameterization {

  def position[A](list:List[A], obj:A): Maybe[Int] = {
    val index = list.indexOf(obj)
    if (index != -1) Just(index) else Nil
  }
}
