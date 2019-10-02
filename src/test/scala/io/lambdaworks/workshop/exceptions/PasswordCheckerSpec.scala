package io.lambdaworks.workshop.exceptions

import io.lambdaworks.workshop.UnitSpec
import io.lambdaworks.workshop.exceptions.PasswordChecker._
import org.scalatest.EitherValues

final class PasswordCheckerSpec extends UnitSpec with EitherValues {
  "Password checker" when {
    "password is invalid" should {
      "return all unsatisfied criteria" in {
        val password = "test"

        val result = PasswordChecker.validate(password)
        result.left.value must contain allElementsOf Seq(
          InvalidLength,
          MissingUppercase,
          MissingNumber
        )
      }
    }

    "password is valid" should {
      "return password" in {
        val password = "Test123"

        val result = PasswordChecker.validate(password)
        result.right.value mustBe password
      }
    }
  }
}
