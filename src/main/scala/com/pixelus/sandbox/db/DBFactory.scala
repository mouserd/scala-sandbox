package com.pixelus.sandbox.db

import com.mongodb.{DB => MongoDB}
import collection.convert.Wrappers.JSetWrapper

class DBFactory private(val driver: MongoDB) {
  def collectionNames = for (name <- new JSetWrapper(driver.getCollectionNames())) yield name
}

// object makes this a singleton.
object DBFactory {
  // Apply provides scala syntactic sugar so that when calling DBFactory(driver) the
  // apply method is automatically called.
  def apply(driver: MongoDB) = new DBFactory(driver)
}