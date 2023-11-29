import scala.util.Try
object Checksum {
  private val PATTERN = "(.+)-(.+)".r
  def verify(fileName: String): Boolean = fileName match
    case PATTERN(name, checksum) =>
      name
        .split("")
        .foldLeft("")((acc, current) =>
          if acc.contains(current) then acc.replace(current, "")
          else acc + current
        ) == checksum
    case _ => false

  def findByIndex(fileNames: List[String], index: Int): Option[String] = Try {
    fileNames.filter(this.verify(_))(index)
  }.toOption
}
