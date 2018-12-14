# Scholiday

A tiny Scala library that contains holiday rules that can be leveraged for date time calculations. This library provides a type class that supports JDK 8 date instances. Plan to support Joda LocalDate, LocalDateTime, DateTime instances in the future.

*NOTE*: This is a very early version of this library that I created quickly.  You can expect significant changes in future versions.

The trait `io.scholiday.Holidays` defines configurations for regional holidays. 
Given an implicit instance of `Holidays` in scope, the `IsHoliday` typeclass can tell you if a given day is a holiday. 
Currently, only rules for US Federal holidays (see
`io.scholiday.regions.UsFederalHolidays`) are implemented. 
I plan to implement rules for other regions in the future. 
It is pretty straightforward to create a `Holidays` instance for another region yourself in the main time - feel free to
contribute a pull request.



### Usage

```scala
  import io.scholiday._
  // import holiday rules for your region
  import io.scholiday.regions.UsFederalHolidays._

  // Christmas holiday on the 25th of December, unless 25th falls on Saturday or Sunday.
  val christmas2018 = LocalDate.of(2018, 12, 25)
  assert(christmas2018.isHoliday == true)

  // Thanksgiving holiday is always the 4th Thursday in November
  val thanksGiving2018 = LocalDate.of(2018, 11, 22)
  assert(thanksGiving2018.isHoliday == true)

  // Random non-holiday
  val sameRandomDay = LocalDate.of(2018, 12, 12)
  assert(sameRandomDay.isHoliday == false)

```

### Supported holiday rules

Currently, this library provides rules for US Federal holidays.  These are the straightforward rules:
* New Years: January 1st unless 1st is Saturday/Sunday.  If so, offset forward to first business day
* Birthday of Martin Luther King Jr. Day: Third Monday in January
* Washington's Birthday: Third Monday in February
* Memorial Day: Last Monday in May
* Independence Day: July 4th unless 4th is Saturday/Sunday.  If so, offset to a business day
* Labor Day: First Monday in September
* Columbus Day: Second Monday in October
* Veteran's Day: Nov 11th unless 11th is Saturday/Sunday. If so, offset to a business day
* Thanksgiving Day: Fourth Thursday in November
* Christmas Day: Dec 25th unless 25th is Saturday/Sunday.  If so, offset to a business day
