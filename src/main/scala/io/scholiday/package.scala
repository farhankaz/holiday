package io

package object scholiday {
  implicit class IsHolidayOps[A](a: A)(implicit isHolidayInstance:IsHoliday[A], holidays: Holidays) {
    def isHoliday = isHolidayInstance.isHoliday(a)
  }
}