package io.scholiday

import java.time.temporal._
import java.time.{DayOfWeek, LocalDate}

object HolidayUtils {

  def offsetForWeekend(temporal: Temporal, forwardOnly:Boolean = false) = temporal.get(ChronoField.DAY_OF_WEEK) match {
    case 6 if !forwardOnly =>
      temporal.minus(1, ChronoUnit.DAYS)
    case 6 if forwardOnly =>
      temporal.plus(2, ChronoUnit.DAYS)
    case 7 =>
      temporal.plus(1, ChronoUnit.DAYS)
    case _ => temporal
  }

  def first(dayOfWeek: DayOfWeek): TemporalAdjuster =
    TemporalAdjusters.firstInMonth(dayOfWeek)

  def second(dayOfWeek: DayOfWeek): TemporalAdjuster = (t:Temporal) =>
    first(dayOfWeek).adjustInto(t).plus(1, ChronoUnit.WEEKS)

  def third(dayOfWeek: DayOfWeek): TemporalAdjuster = (t:Temporal) =>
    first(dayOfWeek).adjustInto(t).plus(2, ChronoUnit.WEEKS)

  def fourth(dayOfWeek: DayOfWeek): TemporalAdjuster = (t:Temporal) =>
    first(dayOfWeek).adjustInto(t).plus(3, ChronoUnit.WEEKS)

  def last(dayOfWeek: DayOfWeek): TemporalAdjuster =
    TemporalAdjusters.lastInMonth(dayOfWeek)

  def atDayOfMonth(dayOfMonth:Int):TemporalAdjuster  = (t:Temporal) =>
    t.`with`(ChronoField.DAY_OF_MONTH, dayOfMonth)

  def weekendOffset(ta:TemporalAdjuster, forwardOnly:Boolean = false):TemporalAdjuster = (t:Temporal) => {
    offsetForWeekend(ta.adjustInto(t), forwardOnly)
  }

}
