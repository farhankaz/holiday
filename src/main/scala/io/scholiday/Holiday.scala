package io.scholiday

import java.time._
import java.time.temporal.TemporalAdjuster

trait Holiday {
  def name:String
  def occursOn(date:LocalDate): Boolean
  def dateInYear(year:Int):LocalDate
}

case class MonthlyHoliday(val name:String, month:Int, temporalAdjuster: TemporalAdjuster) extends Holiday {
  override def occursOn(date: LocalDate): Boolean =
    if (date.getMonthValue != month) false
    else dateInYear(date.getYear) == date

  override def dateInYear(year: Int): LocalDate = LocalDate.of(year, month, 1).`with`(temporalAdjuster)
}

object MonthlyHoliday {
  def apply(name:String, month:Month, temporalAdjuster: TemporalAdjuster):MonthlyHoliday =
    MonthlyHoliday(name, month.getValue, temporalAdjuster)
}

