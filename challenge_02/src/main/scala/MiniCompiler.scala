object MiniCompiler {
  def compile(input: String): String =
    def helper(input: List[Char], value: Int = 0, result: String = ""): String =
      input match
        case Nil => result
        case ::(head, next) =>
          head match
            case '#' => helper(next, value + 1, result)
            case '@' => helper(next, value - 1, result)
            case '*' => helper(next, value * value, result)
            case '&' => helper(next, value, s"$result$value")
            case _   => helper(next, value, result)
    helper(input.toList)
}
