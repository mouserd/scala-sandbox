package com.pixelus.sandbox.db

import com.mongodb.DBObject

case class Query(q: DBObject, option: QueryOption = NoOption) {

  def sort(sorting: DBObject) = Query(q, Sort(sorting, option))

  def skip(skip: Int) = Query(q, Skip(skip, option))

  def limit(limit: Int) = Query(q, Limit(limit, option))
}
