package io.lambdaworks.workshop.functions
import com.lightbend.emoji.ShortCodes.Defaults._
import com.lightbend.emoji.ShortCodes.Implicits._

import scala.util.Try

object EmojifyText {

  def emojify(sentence: String): String = {
    val words = sentence.filter(_ != '.').split(" ")
    words
      .map(c => emojiOrWord(c))
      .mkString(" ")

    // why is the above diff from words.map(...) ; words.mkString
  }

  private def emojiOrWord(word: String): String =
    Try(word.toLowerCase.emoji.toString).getOrElse(word)

  private def isLetter(char: Char) = char.isLetter

}
