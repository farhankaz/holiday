package io.scholiday
import java.time.LocalDate

import io.scholiday.regions.UsFederalHolidays
import utest._

object UsFederalHolidaysTests extends TestSuite {

  def d(year:Int, month:Int, dayOfMonth:Int) =
    LocalDate.of(year, month, dayOfMonth)

  def tests = Tests{
    "US Federal Holidays" - {
      "2018" - {
        "Has 10 Holidays" - assert(UsFederalHolidays.allHolidays.size == 10)
        "New Years Day" - assert(d(2018, 1, 1).isHoliday)
        "Martin Luther King" - assert(d(2018, 1, 15).isHoliday)
        "Washington's Birthday" - assert(d(2018, 2, 19).isHoliday)
        "Memorial Day" - assert(d(2018, 5, 28).isHoliday)
        "Independence Day" - assert(d(2018, 7, 4).isHoliday)
        "Labor Day" - assert(d(2018, 9, 3).isHoliday)
        "Columbus Day" - assert(d(2018, 10, 8).isHoliday)
        "Veteran's Day 2018" - {
          assert(LocalDate.of(2018, 11, 11).isHoliday == false)
          assert(LocalDate.of(2018, 11, 12).isHoliday)
        }
        "Thanksgiving Day" - assert(d(2018, 11, 22).isHoliday)
        "Christmas 2018" - assert(d(2018, 12, 25).isHoliday)
      }
      "2019" - {
        "Has 10 Holidays" - assert(UsFederalHolidays.allHolidays.size == 10)
        "New Years Day" - assert(d(2019, 1, 1).isHoliday)
        "Martin Luther King" - assert(d(2019, 1, 21).isHoliday)
        "Washington's Birthday" - assert(d(2019, 2, 18).isHoliday)
        "Memorial Day" - assert(d(2019, 5, 27).isHoliday)
        "Independence Day" - assert(d(2019, 7, 4).isHoliday)
        "Labor Day" - assert(d(2019, 9, 2).isHoliday)
        "Columbus Day" - assert(d(2019, 10, 14).isHoliday)
        "Veteran's Day 2018" - {
          assert(LocalDate.of(2019, 11, 11).isHoliday)
          assert(LocalDate.of(2019, 11, 12).isHoliday == false)
        }
        "Thanksgiving Day" - assert(d(2019, 11, 28).isHoliday)
        "Christmas 2018" - assert(d(2019, 12, 25).isHoliday)
      }
    }
  }
}