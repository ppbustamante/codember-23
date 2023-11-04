object Crypto {
  def decryption(encryptedText: String): String =
    encryptedText
      .toLowerCase()
      .split(" ")
      .zipWithIndex
      .groupBy(text => text._1)
      .toList
      .sortBy(g => g._2.minBy(value => value._2)._2)
      .map((key, list) => s"$key${list.size}")
      .mkString
}
