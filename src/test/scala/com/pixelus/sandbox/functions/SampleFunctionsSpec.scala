package com.pixelus.sandbox.functions

import com.pixelus.sandbox.BaseSpec

class SampleFunctionsSpec extends BaseSpec {

  var sampleFunctions: SampleFunctions = _

  before {
    sampleFunctions = SampleFunctions()
  }

  describe("#addOne") {

    it("should add 1 to a given number") {
      sampleFunctions.addOne(3) should equal(4)
    }

    it("should increment all items in a list when passed to map") {
      List(1, 2, 3).map(sampleFunctions.addOne) should equal(List(2, 3, 4))
    }

    describe("#mapWithMatchers") {

      it("should increment all items in a list using recursion") {
        val list = List(1, 2, 3)

        sampleFunctions.mapWithMatchers(list, sampleFunctions.addOne) should equal(List(2, 3, 4))
      }
    }

    describe("#mapWithForComprehension") {

      it("should increment all items in a list using a for-comprehension") {
        val list = List(1, 2, 3)

        sampleFunctions.mapWithForComprehension(list, sampleFunctions.addOne) should equal(List(2, 3, 4))
      }
    }
  }

  describe("#addOneWithNestedFunction") {

    it("should add 1 to a given number") {
      sampleFunctions.addOneWithNestedFunction(3) should equal(4)
    }

    it("should increment all items in a list when passed to map") {
      List(1, 2, 3).map(sampleFunctions.addOneWithNestedFunction) should equal(List(2, 3, 4))
    }
  }

  describe("#doublerPartial") {

    it("should double integer using a partial function") {
      sampleFunctions.doublerPartial(4) should equal(8)
    }
  }

  describe("#doublerCurried") {

    it("should double integer using a curried function") {
      sampleFunctions.doublerCurried(5) should equal(10)
    }
  }

  describe("#capitalizeVarArgs") {

    it("should capitalize all strings using a variable argument function") {
      sampleFunctions.capitalizeVarArgs("dave", "pete", "mike", "harry") should equal(List("DAVE", "PETE", "MIKE", "HARRY"))
    }
  }
}
