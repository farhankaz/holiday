package io.scholiday

import java.time.{LocalDate, LocalDateTime}

trait IsHoliday[A] {
  def isHoliday(a: A)(implicit holidays:Holidays): Boolean
}

object IsHoliday {
  implicit val jdkLocalDateIsHoliday:IsHoliday[LocalDate] = new IsHoliday[LocalDate] {
    override def isHoliday(a: LocalDate)(implicit holidays:Holidays): Boolean =
      holidays.isHoliday(a)
  }

  implicit val jdkLocalDateTimeIsHoliday:IsHoliday[LocalDateTime] = new IsHoliday[LocalDateTime] {
    override def isHoliday(a: LocalDateTime)(implicit holidays:Holidays): Boolean =
      holidays.isHoliday(a.toLocalDate)
  }
}
