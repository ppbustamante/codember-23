import scala.util.Try

object Cipher {
  val Pattern = "(\\d+)-(\\d+) (.): (.+)".r

  def findInvalidCases(cases: List[String]): List[String] =
    cases.filter {
      case Pattern(min, max, char, word) =>
        val count = word.count(_.toString == char)
        !(count >= min.toInt && count <= max.toInt)
      case _ => false
    }

  def findByIndex(cases: List[String], index: Int): Option[String] =
    Try(findInvalidCases(cases)(index)).toOption

}
