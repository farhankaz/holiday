package io.scholiday.regions

import java.time.{DayOfWeek, LocalDate, Month}

import io.scholiday.HolidayUtils._
import io.scholiday.{Holidays, MonthlyHoliday}

/**
  * Defines US Federal Holidays
  */
object UsFederalHolidays extends Holidays {
  val allHolidays = Seq(
    MonthlyHoliday("New Year's Day", Month.JANUARY, weekendOffset(atDayOfMonth(1), true)),
    MonthlyHoliday("Martin Luther King Jr.", Month.JANUARY, third(DayOfWeek.MONDAY)),
    MonthlyHoliday("Washington's Birthday", Month.FEBRUARY, third(DayOfWeek.MONDAY)),
    MonthlyHoliday("Memorial Day", Month.MAY, last(DayOfWeek.MONDAY)),
    MonthlyHoliday("Independence Day", Month.JULY, weekendOffset(atDayOfMonth(4))),
    MonthlyHoliday("Labor Day", Month.SEPTEMBER, first(DayOfWeek.MONDAY)),
    MonthlyHoliday("Columbus Day", Month.OCTOBER, second(DayOfWeek.MONDAY)),
    MonthlyHoliday("Veteran's Day", Month.NOVEMBER, weekendOffset(atDayOfMonth(11))),
    MonthlyHoliday("Thanksgiving", Month.NOVEMBER, fourth(DayOfWeek.THURSDAY)),
    MonthlyHoliday("Christmas", Month.DECEMBER, weekendOffset(atDayOfMonth(25)))
  )

  override def isHoliday(date: LocalDate): Boolean =
    allHolidays.find(_.occursOn(date)).map(_ => true).getOrElse(false)

}