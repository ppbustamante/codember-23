class CryptoSuite extends munit.FunSuite {
  test("codember examples") {
    val encrypted_1 = "llaveS casa CASA casa llaves"
    val encrypted_2 = "taza ta za taza"
    val encrypted_3 = "casas casa casasas"
    val encrypted_4 = "gato perro perro coche Gato peRRo sol"

    assertEquals(Crypto.decryption(encrypted_1), "llaves2casa3")
    assertEquals(Crypto.decryption(encrypted_2), "taza2ta1za1")
    assertEquals(Crypto.decryption(encrypted_3), "casas1casa1casasas1")
    assertEquals(Crypto.decryption(encrypted_4), "gato2perro3coche1sol1")
  }
}
