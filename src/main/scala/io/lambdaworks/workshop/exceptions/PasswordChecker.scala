package io.lambdaworks.workshop.exceptions

object PasswordChecker {

  def validate(password: String): Either[List[Throwable], String] = ???

  private def minNumberOfChars(password: String, length: Int): Either[Throwable, String] = ???

  private def containsUpperCase(password: String): Either[Throwable, String] = ???

  private def containsLowerCase(password: String): Either[Throwable, String] = ???

  private def containsNumber(password: String): Either[Throwable, String] = ???

  object InvalidLength    extends Throwable("Password must contain at least 5 characters.")
  object MissingUppercase extends Throwable("Password must contain uppercase letter.")
  object MissingLowercase extends Throwable("Password must contain lowercase letter.")
  object MissingNumber    extends Throwable("Password must contain number.")

}
