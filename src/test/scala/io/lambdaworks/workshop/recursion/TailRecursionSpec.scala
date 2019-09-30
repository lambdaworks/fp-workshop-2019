package io.lambdaworks.workshop.recursion

import io.lambdaworks.workshop.UnitSpec
import io.lambdaworks.workshop.recursion.TailRecursion._

final class TailRecursionSpec extends UnitSpec {
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
