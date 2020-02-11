package extractors

object ExtractDayFromTimeStamp {

  def apply(date: String, time: String) = s"$date $time"

  def unapply(timeStamp: String): Option[String] = {
    val stamp = timeStamp split (" ")
    if (stamp.length == 2) {
      val day = stamp(0) split ("-")
      if (day.length == 3) {
        Some(day(0))
      }
      else None
    }
    else None
  }

}
