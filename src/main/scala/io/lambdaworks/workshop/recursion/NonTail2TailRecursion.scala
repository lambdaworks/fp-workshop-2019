package io.lambdaworks.workshop.recursion

import scala.annotation.tailrec

/**
  * Rewrite below non tail-recursive functions to tail-recursive one.
  * Add @tailrec annotation to prove it.
  */
object NonTail2TailRecursion {

  def factorial(n: Int): Int =
    if (n <= 0) 1 else n * factorial(n - 1)

  def factorialT(n: Int): Int = {
    @tailrec
    def loop(n: Int, acc: Int = 1): Int =
      if (n == 0) acc else loop(n - 1, acc * n)

    loop(n)
  }
  def cubesOfEvens(numbers: List[Double]): List[Double] =
    numbers match {
      case x :: xs if x % 2 == 0 => Math.pow(x, 3) +: cubesOfEvens(xs)
      case _ :: xs => cubesOfEvens(xs)
      case Nil     => List.empty
    }

  def cubesOfEvenT(numbers: List[Double]): List[Double] = {
    @tailrec
    def loop(numbers: List[Double], acc: List[Double] = Nil): List[Double] = {
      numbers match {
        case x :: xs if x % 2 == 0 => loop(xs, Math.pow(x, 3) +: acc)
        case _ :: xs => loop(xs, acc)
        case Nil     => acc
      }
    }
    loop(numbers)
  }
}
