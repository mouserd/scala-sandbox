package com.pixelus.sandbox.parameterization

sealed abstract class Maybe[+A] {

  def isEmpty: Boolean
  def get: A
  // Lower bound limit says that B must be a super-type of A
  // The opposite, an upper bound limit (B <: A) says that B must be a sub-type of A.
  def getOrElse[B >: A](default: B): B = {
    if (isEmpty) default else get
  }
}

case class Just[A](value: A) extends Maybe[A] {
  def isEmpty = false
  def get = value
}

case object Nil extends Maybe[Nothing] {
  def isEmpty = true
  def get = throw new NoSuchElementException("Nil.get")
}
