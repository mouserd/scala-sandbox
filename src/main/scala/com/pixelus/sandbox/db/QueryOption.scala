package com.pixelus.sandbox.db

import com.mongodb.DBObject

sealed trait QueryOption

case object NoOption extends QueryOption

case class Sort(sorting: DBObject, anotherOption: QueryOption) extends QueryOption

case class Skip(number: Int, anotherOption: QueryOption) extends QueryOption

case class Limit(limit: Int, anotherOption: QueryOption) extends QueryOption
