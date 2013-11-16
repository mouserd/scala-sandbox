package com.pixelus

import growl._
import sbt._

object GrowlMessageFormatter {

  val errorIcon = Option(imagePath + "/error.png")
  val passIcon = Option(imagePath + "/pass.png")
  val failIcon = Option(imagePath + "/fail.png")

  def imagePath = file("./project/growl/images/")

  def shortResourceName(resName: String): String = {
    resName.substring(resName.lastIndexOf('.') + 1)
  }

  def specFormatter(res: GroupResult) = {
    GrowlResultFormat(
      Some(res.name),
      shortResourceName(res.name),
      res.status match {
        case TestResult.Error  => "Error"
        case TestResult.Passed => "Passed"
        case TestResult.Failed => "Failed"
      },
      res.status match {
        case TestResult.Error | TestResult.Failed => true
        case _                                    => false
      },
      res.status match {
        case TestResult.Error  => errorIcon
        case TestResult.Passed => passIcon
        case TestResult.Failed => failIcon
      }
    )
  }

  def summaryFormatter(res: AggregateResult) = {
    GrowlResultFormat(
      Some("All Tests"),
      (res.status match {
        case TestResult.Error  => "Error!"
        case TestResult.Passed => "Success!"
        case TestResult.Failed => "Failure!"
      }),
      "%d Tests \n- %d Failed\n- %d Errors\n- %d Passed\n- %d Skipped" format(
          res.count, res.failures, res.errors, res.passed, res.skipped
          ),
      res.status match {
        case TestResult.Error | TestResult.Failed => true
        case _                                    => false
      },
      res.status match {
        case TestResult.Error  => errorIcon
        case TestResult.Passed => passIcon
        case TestResult.Failed => failIcon
      }
    )
  }
}
