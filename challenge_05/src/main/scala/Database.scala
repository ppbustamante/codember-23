object Database {
  private def isAlphanumeric(text: String): Boolean =
    text.matches("^[a-zA-Z0-9]*$")

  private def isEmail(text: String): Boolean =
    text.matches("^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")

  private def check(credential: String): Boolean = {
    credential.split(",", -1).toList match
      case List(
            id: String,
            username: String,
            email: String,
            age: String,
            location: String
          )
          if isAlphanumeric(id) && isAlphanumeric(username) && isEmail(
            email
          ) && (age.isEmpty() || age.forall(Character.isDigit)) =>
        true
      case _ => false
  }

  def isInvalid(credential: String): Boolean = !check(credential)

  private def invalidCredentials(credentials: List[String]): List[String] =
    credentials.filter(isInvalid(_))

  def generateCode(credentials: List[String]): String =
    invalidCredentials(credentials)
      .map(credential =>
        credential.split(",", -1).toList match
          case List(id, username: String, email, age, location) =>
            username.charAt(0)
          case _ => ""
      )
      .mkString
}
