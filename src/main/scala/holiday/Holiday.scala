package holiday

import java.time._
import java.time.temporal.TemporalAdjuster

object implicits {
  implicit class IsHolidayOps[A](a: A)(implicit isHolidayInstance:IsHoliday[A], holidays: Holidays) {
    def isHoliday = isHolidayInstance.isHoliday(a)
  }
}

trait Holiday {
  def name:String
  def occursOn(date:LocalDate): Boolean
  def dateInYear(year:Int):LocalDate
}

object Holiday {
  def apply(n:String, m:Month, temporalAdjuster: TemporalAdjuster) = {
    new MonthlyHoliday {
      override def month: Int = m.getValue

      override def name: String = n

      override def dateInYear(year: Int): LocalDate = LocalDate.of(year, month, 1).`with`(temporalAdjuster)
    }
  }
}

trait MonthlyHoliday extends Holiday {
  def month: Int

  override def occursOn(date: LocalDate): Boolean =
    if (date.getMonthValue != month) false
    else dateInYear(date.getYear) == date
}

object MonthlyHoliday {
  def apply(n:String, m:Int)(forYear:(Int, Int)=>LocalDate): MonthlyHoliday = {
    new MonthlyHoliday {
      override def month: Int = m

      override def name: String = n

      override def dateInYear(year: Int): LocalDate = forYear(year, month)
    }
  }

  def apply(n:String, m:Month, temporalAdjuster: TemporalAdjuster) = {
    new MonthlyHoliday {
      override def month: Int = m.getValue

      override def name: String = n

      override def dateInYear(year: Int): LocalDate = LocalDate.of(year, month, 1).`with`(temporalAdjuster)
    }
  }
}

trait Holidays {
  def isHoliday(date:LocalDate): Boolean
  def allHolidays: Seq[Holiday]
}

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

