package com.pixelus.sandbox.functions

import com.pixelus.sandbox.BaseSpec

class SampleFunctionsSpec extends BaseSpec {

  describe("#addOne") {

    it("should add 1 to a given number") {
      SampleFunctions.addOne(3) should equal(4)
    }

    it("should increment all items in a list when passed to map") {
      List(1, 2, 3).map(SampleFunctions.addOne) should equal(List(2, 3, 4))
    }

    describe("#map") {

      it("should increment all items in a list using recursion") {
        val list = List(1, 2, 3)

        SampleFunctions.map(list, SampleFunctions.addOne) should equal(List(2, 3, 4))
      }
    }

    describe("#map1") {

      it("should increment all items in a list using a for-comprehension") {
        val list = List(1, 2, 3)

        SampleFunctions.map1(list, SampleFunctions.addOne) should equal(List(2, 3, 4))
      }
    }
  }

  describe("#addOneWithNestedFunction") {

    it("should add 1 to a given number") {
      SampleFunctions.addOneWithNestedFunction(3) should equal(4)
    }

    it("should increment all items in a list when passed to map") {
      List(1, 2, 3).map(SampleFunctions.addOneWithNestedFunction) should equal(List(2, 3, 4))
    }
  }

}
