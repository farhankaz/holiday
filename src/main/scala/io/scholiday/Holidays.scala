package io.scholiday

import java.time.LocalDate

import io.scholiday.regions.UsFederalHolidays

trait Holidays {
  def isHoliday(date:LocalDate): Boolean
  def allHolidays: Seq[Holiday]
}

object Holidays extends UsFederalHolidays