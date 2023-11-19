// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MiniCompilerSuite extends munit.FunSuite {
  test("codember_example") {
    val input = "&##&*&@&"
    val expected = "0243"
    val output = MiniCompiler.compile(input)
    assertEquals(expected, output)
  }

  test("codember_challenge") {
    val input =
      "&###@&*&###@@##@##&######@@#####@#@#@#@##@@@@@@@@@@@@@@@*&&@@@@@@@@@####@@@@@@@@@#########&#&##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@&"
    val expected = "024899455"
    val output = MiniCompiler.compile(input)
    assertEquals(expected, output)
  }
}
