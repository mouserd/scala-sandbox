package com.pixelus.sandbox

import java.io._

class ForComprehensions {

  def filenameList(path:String, fileType:String): Array[String] = {
    val files = new File(path).listFiles;

    var txtFiles = Array[String]()
    for (file <- files) {
      if (file.getName.endsWith(fileType)) txtFiles :+= file.getName
    }

    txtFiles;
  }
}
