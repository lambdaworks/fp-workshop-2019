package io.lambdaworks.workshop.firstclass

import io.lambdaworks.workshop.firstclass.Drop.dropIf
import org.scalatest.{MustMatchers, WordSpec}

final class DropSpec extends WordSpec with MustMatchers {
  "DropIf function" should {
    "drop elements that satisfies predicate function" in {
      val numbers = List(1, 2, 56, 14, 7, 31, 8)

      val result = dropIf(numbers, (x: Int) => x % 2 == 0)
      result mustBe List(1, 7, 31)
    }
  }
}
