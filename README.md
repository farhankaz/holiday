# Holiday

A Scala library to support date time calculations that need account for regional holidays.  This library provides type classes that support JDK 8 date instances.
Plan to provide support for Joda LocalDate, LocalDateTime, DateTime instances in the future.

*NOTE*: This is a very early version of this library that I created quickly.  You can expect significant changes in future versions.

The trait holiday.Holidays defines configurations for regional holidays.  This implementation provides a Holidays instance of US Federal Holidays (see
holiday.local.UsFederalHolidays).  I plan to provide Holidays implementations for other regions in the future.

Given an implicit instance of Holidays in scope and IsHoliday typeclass can tell you if a given day is a holiday.

### Supported holiday rules

Currently, this library provides an instance of Holidays for US Federal holidays with the following rules:
* New Years: January 1st unless 1st is Saturday/Sunday.  If so, offset to first business day
* Birthday of Martin Luther King Jr. Day: Third Monday in January
* Washington's Birthday: Third Monday in February
* Memorial Day: Last Monday in May
* Independence Day: July 4th unless 4th is Saturday/Sunday.  If so, offset to a business day
* Labor Day: First Monday in September
* Columbus Day: Second Monday in October
* Veteran's Day: Nov 11th unless 11th is Saturday/Sunday. If so, offset to a business day
* Thanksgiving Day: Fourth Thursday in November
* Christmas Day: Dec 25th unless 25th is Saturday/Sunday.  If so, offset to a business day

### Usage

```scala
  import holiday.implicits._
  // import implicit instance of holiday.Holidays for the region
  import holiday.local.UsFederalHolidays._

  // Christmas holiday on the 25th of December, unless 25th falls on Saturday or Sunday.
  val christmas2018 = LocalDate.of(2018, 12, 25)
  assert(christmas2018.isHoliday == true)

  // Thanksgiving holiday is always the 4th Thursday in November
  val thanksGiving2018 = LocalDate.of(2018, 11, 22)
  assert(thanksGiving2018.isHoliday == true)

  // Non holiday
  val sameRandomDay = LocalDate.of(2018, 12, 12)
  assert(sameRandomDay.isHoliday == false)

```