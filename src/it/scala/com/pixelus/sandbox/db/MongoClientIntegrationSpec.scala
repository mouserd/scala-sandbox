package com.pixelus.sandbox.db

import com.mongodb.{DBObject, BasicDBObject}
import org.scalatest._

class MongoClientIntegrationSpec extends FunSuite with ShouldMatchers with BeforeAndAfter {

  val CollectionName:String = "myCollection"

  var client:MongoClient = _
  var db:DB = _

  before {
    client = new MongoClient()
    db = client.createDB("mydb")

    def collection = db.updatableCollection(CollectionName)
    collection +=(createDBObject())
  }


  private def createDBObject():DBObject = {
    val obj = new BasicDBObject()
    obj.put("key", "value")
    obj
  }

  after {
    client.dropDB("mydb")
  }

  test("#collectionNames should return valid collection names") {

    db.collectionNames should contain(CollectionName)
  }

  test("#getCount should return number of matching objects ") {
    db.updatableCollection(CollectionName).getCount(createDBObject()) should equal(1)
  }

  test("#appendOperator should add object to updatable collection") {
    val dummyObject = createDBObject()
    val collection = db.updatableCollection(CollectionName)

    collection.getCount(dummyObject) should equal(1)
    collection += createDBObject()
    collection.getCount(dummyObject) should equal(2)
  }

  test("#removeOperator should remove object from updatable collection") {

    val deleteObject = createDBObject()
    val collection = db.updatableCollection(CollectionName)

    collection.getCount(deleteObject) should equal(1)
    collection -=(deleteObject)
    collection.getCount(deleteObject) should equal (0)
  }

  test("#drop should drop collection from administrable collection") {
    val collection = db.administrableCollection(CollectionName)

    db.collectionNames should contain(CollectionName)
    collection.drop()

    db.collectionNames should not contain(CollectionName)
  }
}


