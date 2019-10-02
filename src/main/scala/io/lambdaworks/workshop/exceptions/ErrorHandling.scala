package io.lambdaworks.workshop.exceptions

object ErrorHandling {

  def divide(x: Int, y: Int): Double =
    if (y == 0) {
      throw new IllegalArgumentException("Unable to divide by zero.")
    } else {
      x / y
    }

  def safeDivide(x: Int, y: Int): Either[Throwable, Double] =
    if (y == 0) {
      Left(new IllegalArgumentException("Unable to divide by zero."))
    } else {
      Right(x / y)
    }

  def findNumber(numbers: Seq[Int], number: Int): Option[Int] =
    numbers.find(_ == number)

}
