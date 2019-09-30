package io.lambdaworks.workshop.recursion

import scala.annotation.tailrec

object TailRecursion {

  /**
    *  Non tail-recursive
    *
    *  Stack trace for sumFirstN(5)
    *
    *  sumFirstN(5)
    *  5 + sumFirstN(4)
    *  5 + (4 + sumFirstN(3))
    *  5 + (4 + (3 + sumFirstN(2)))
    *  5 + (4 + (3 + (2 + sumFirstN(1))))
    *  5 + (4 + (3 + (2 + 1)))
    *  15
    */
  def sumFirstN(n: Int): Int =
    if (n == 1) n else n + sumFirstN(n - 1)

  /**
    *  Tail-recursive
    *
    *  Stack trace for sumFirstNT(5)
    *
    *  loop(5, 0)
    *  loop(4, 5)
    *  loop(3, 9)
    *  loop(2, 12)
    *  loop(1, 14)
    *  loop(0, 15)
    */
  def sumFirstNT(n: Int): Int = {
    @tailrec
    def loop(n: Int, accumulator: Int = 0): Int =
      if (n == 0) accumulator else loop(n - 1, accumulator + n)

    loop(n)
  }

  // Should use in base condition to determine smaller stack trace for tail-recursive function
  private def getStackTrace(methodName: String): Array[StackTraceElement] =
    Thread.currentThread.getStackTrace.filter(_.getMethodName == methodName)

}
