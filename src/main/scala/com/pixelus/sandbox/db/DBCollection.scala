package com.pixelus.sandbox.db

import com.mongodb.{DBCollection => MongoDBCollection, DBObject}

class DBCollection(override val underlying:MongoDBCollection)
  extends ReadyOnly {}

trait ReadyOnly {

  val underlying: MongoDBCollection

  def name = underlying.getName
  def fullName = underlying.getFullName
  def find(doc: DBObject) = underlying.find(doc)
  def findOne(doc: DBObject) = underlying.findOne(doc)
  def findOne = underlying.findOne
  def getCount(doc: DBObject) = underlying.getCount
}

trait Administrable extends ReadyOnly {
  def drop():Unit = underlying.drop
  def dropIndexes():Unit = underlying.dropIndexes
}

trait Updatable extends ReadyOnly {
  def -=(doc: DBObject):Unit = underlying.remove(doc)
  def +=(doc: DBObject):Unit = underlying.save(doc)
}
