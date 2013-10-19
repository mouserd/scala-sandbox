package com.pixelus.sandbox

class ForComprehensionsSpec extends BaseSpec {

  var forComprehensions:ForComprehensions = _;

  before {
    forComprehensions = new ForComprehensions
  }

  test("#filenameList should return only txt files") {
    forComprehensions.filenameList("src/test/resources/com/pixelus/sandbox", ".txt") should have length(2)
  }

  test("#mergeAllListItems should returned merged list items") {
    val list1 = List("itemA", "itemB")
    val list2 = List("item1", "item2")

    forComprehensions.mergeAllListItems(list1, list2) should equal (
      List("itemAitem1", "itemAitem2", "itemBitem1", "itemBitem2"))
  }
}
