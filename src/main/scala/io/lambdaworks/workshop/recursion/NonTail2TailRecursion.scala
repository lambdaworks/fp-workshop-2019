package io.lambdaworks.workshop.recursion

/**
  * Rewrite below non tail-recursive functions to tail-recursive one.
  * Add @tailrec annotation to prove it.
  */
object NonTail2TailRecursion {

  def factorial(n: Int): Int =
    if (n <= 0) 1 else n * factorial(n - 1)

  def cubesOfEvens(numbers: List[Double]): List[Double] =
    numbers match {
      case x :: xs if x % 2 == 0 => Math.pow(x, 3) +: cubesOfEvens(xs)
      case _ :: xs => cubesOfEvens(xs)
      case Nil     => List.empty
    }

}
