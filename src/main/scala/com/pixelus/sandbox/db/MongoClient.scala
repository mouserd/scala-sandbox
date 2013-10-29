package com.pixelus.sandbox.db

import com.mongodb.{MongoClient => Mongo}   // import and remap!

class MongoClient(val host:String, val port:Int) {

  require(host != null, "You must provide a hostname")

  private val driver = new Mongo(host, port)

  def this() = this("127.0.0.1", 27017)
  def this(host:String) = this(host, 27017)

  def version = driver.getVersion
  def dropDB(name:String) { driver.dropDatabase(name) }
  def createDB(name:String) = DB(driver.getDB(name))
  def db(name:String) = DB(driver.getDB(name))
}
