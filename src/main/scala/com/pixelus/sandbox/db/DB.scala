package com.pixelus.sandbox.db

import com.mongodb.{DB => MongoDB}
import collection.mutable

// import and remap!
import collection.convert.Wrappers.JSetWrapper

/**
 * DB Companion Class.
 *
 * Only companion objects can access this private class.
 */
class DB private(val driver: MongoDB) {

  private def collection(name:String) = driver.getCollection(name)
  def readOnlyCollection(name:String) = new DBCollection(collection(name)) with Memoizer
  def administrableCollection(name:String) = new DBCollection(collection(name)) with Administrable with Memoizer
  def updatableCollection(name:String) = new DBCollection(collection(name)) with Updatable with Memoizer

  def collectionNames: mutable.Set[String] = for (name <- new JSetWrapper(driver.getCollectionNames())) yield name
}

/**
 * DB Companion Object.
 *
 * This is a singleton scala object.
 */
object DB {

  /**
   * Apply provides scala syntactic sugar so that when calling DB(driver) the apply
   * method is automatically called.
   *
   * @param driver A Mongo library DB driver.
   * @return a new DB class instance.
   */
  def apply(driver: MongoDB) = new DB(driver)
}