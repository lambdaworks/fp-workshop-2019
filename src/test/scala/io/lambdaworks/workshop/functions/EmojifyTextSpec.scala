package io.lambdaworks.workshop.functions

import io.lambdaworks.workshop.UnitSpec

final class EmojifyTextSpec extends UnitSpec {
  "Emojify function" should {
    "replace words with emojis" in {
      val sentence = "A house without a cat or a little child is a house without joy or laughter."
      val emojifiedSentence =
        "\uD83C\uDD70 \uD83C\uDFE0 without \uD83C\uDD70 \uD83D\uDC31 or \uD83C\uDD70 little child is \uD83C\uDD70 \uD83C\uDFE0 without \uD83D\uDE02 or laughter"
      EmojifyText.emojify(sentence) mustBe emojifiedSentence
    }
  }
}
