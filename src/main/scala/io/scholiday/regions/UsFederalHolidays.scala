package io.scholiday.regions

import java.time.{DayOfWeek, LocalDate, Month}

import io.scholiday.HolidayUtils._
import io.scholiday.{Holiday, Holidays}


trait UsFederalHolidays {
  implicit val holidays = new Holidays {
    val allHolidays = Seq(
      Holiday("New Year's Day", Month.JANUARY, weekendOffset(atDayOfMonth(1), true)),
      Holiday("Martin Luther King Jr.", Month.JANUARY, third(DayOfWeek.MONDAY)),
      Holiday("Washington's Birthday", Month.FEBRUARY, third(DayOfWeek.MONDAY)),
      Holiday("Memorial Day", Month.MAY, last(DayOfWeek.MONDAY)),
      Holiday("Independence Day", Month.JULY, weekendOffset(atDayOfMonth(4))),
      Holiday("Labor Day", Month.SEPTEMBER, first(DayOfWeek.MONDAY)),
      Holiday("Columbus Day", Month.OCTOBER, second(DayOfWeek.MONDAY)),
      Holiday("Veteran's Day", Month.NOVEMBER, weekendOffset(atDayOfMonth(11))),
      Holiday("Thanksgiving", Month.NOVEMBER, fourth(DayOfWeek.THURSDAY)),
      Holiday("Christmas", Month.DECEMBER, weekendOffset(atDayOfMonth(25)))
    )

    override def isHoliday(date: LocalDate): Boolean =
      allHolidays.find(_.occursOn(date)).map(_ => true).getOrElse(false)

  }
}