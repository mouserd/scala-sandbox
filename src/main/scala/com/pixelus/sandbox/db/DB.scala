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