package com.pixelus.sandbox.db

import com.mongodb.{DBCollection => MongoDBCollection, DBCursor, DBObject}

class DBCollection(override val underlying:MongoDBCollection)
  extends Memoizer {}

trait ReadyOnly {

  val underlying: MongoDBCollection

  def name = underlying.getName
  def fullName = underlying.getFullName
  def find(doc: DBObject): DBCursor = underlying.find(doc)

  def find(query: Query): DBCursor = {
    def applyOptions(cursor:DBCursor, option: QueryOption): DBCursor = {
      option match {
        case Skip(skip, next) => applyOptions(cursor.skip(skip), next)
        case Sort(sorting, next) => applyOptions(cursor.sort(sorting), next)
        case Limit(limit, next) => applyOptions(cursor.limit(limit), next)
        case NoOption => cursor
      }
    }
    applyOptions(find(query.q), query.option)
  }

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

trait Memoizer extends ReadyOnly {

  val cache = Map[Int, DBObject]()

  override def findOne() = {
    cache.getOrElse(-1, super.findOne)
  }

  override def findOne(doc: DBObject) = {
    cache.getOrElse(doc.hashCode, super.findOne(doc))
  }
}
