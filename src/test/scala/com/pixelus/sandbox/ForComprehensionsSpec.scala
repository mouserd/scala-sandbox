package com.pixelus.sandbox

class ForComprehensionsSpec extends BaseSpec {

  test("file list should return only txt files") {
    new ForComprehensions().filenameList("src/test/resources/com/pixelus/sandbox", ".txt") should have length(2)
  }
}
