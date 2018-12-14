package io.scholiday

import java.time.LocalDate

trait Holidays {
  def isHoliday(date:LocalDate): Boolean
  def allHolidays: Seq[Holiday]
}
