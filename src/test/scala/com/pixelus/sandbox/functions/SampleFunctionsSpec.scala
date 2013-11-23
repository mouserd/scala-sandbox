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
