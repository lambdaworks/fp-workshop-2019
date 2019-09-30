package io.lambdaworks.workshop.recursion

import org.scalatest.{MustMatchers, WordSpec}
import io.lambdaworks.workshop.recursion.TailRecursion._

class TailRecursionSpec extends WordSpec with MustMatchers {
  "Tail-recursive function" when {
    "compare with non tail-recursive function" should {
      "take less space on the execution stack" in {
        val n = Double.PositiveInfinity.toInt

        a[StackOverflowError] should be thrownBy sumFirstN(n)

        sumFirstNT(n) mustBe n * (n + 1) / 2
      }
    }
  }
}
