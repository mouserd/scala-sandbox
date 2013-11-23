package com.pixelus.sandbox.parameterization

import com.pixelus.sandbox.BaseSpec

class ParameterizationSpec extends BaseSpec {

  var parameterization: Parameterization = _

  before {
    parameterization = new Parameterization
  }

  describe("#position") {

    it("should get correct position for List of Ints") {
      val list = List(1, 2, 3, 4, 5)
      parameterization.position(list, 3).get should equal(2)
    }

    it("should get correct position for List of Strings") {
      val list = List("Mike", "Jack", "Phil", "Russ")
      parameterization.position(list, "Jack").get should equal(1)
    }

    it("should get default position for object that doesn't exist in List but using getOrElse") {
      val list = List("Mike", "Jack", "Phil", "Russ")
      parameterization.position(list, "Pedro").getOrElse(-1) should equal(-1)
    }

    it("should get Nil for object that doesn't exist in List") {
      val list = List("Mike", "Jack", "Phil", "Russ")
      parameterization.position(list, "Fred") should equal(Nil)
    }

    it("should throw exception using get on for object that doesn't exist in List") {
      val list = List("Mike", "Jack", "Phil", "Russ")
      intercept[NoSuchElementException] {
        parameterization.position(list, "Fred").get
      }
    }
  }
}
