# Lecture 6: Error handling 

As we mentioned in the earlier lectures, FP is based on the pure functions that will be composed in the bigger picture.
We know that every function for some input returns the appropriate output.
But what should we do when a function does not have a result value for some input? 
For example, we are trying to divide the number with zero. 

In most languages, this case is handled by throwing exceptions.

```scala
def divide(x: Int, y: Int): Double =
  if (y == 0) {
    throw new IllegalArgumentException("Unable to divide by zero.")
  } else {
    x / y
  }
```

But we mentioned that function that throws the exception is not a pure function. 

Another problem in this situation is that we allow errors to propagate silently. 
The caller of the function won't be able to know that the function should throw an error from its return type.  

We should solve the problem by using the build-in types `Option`, `Either` or `Try`.

## Best practice

In particular, when:

- something might not be there, use `Option`.
- something might fail, use `Either`.
- something is rude and might throw an `Exception`, use `Try`.

## Either

The most common way of handling the exceptions in Scala is using `Either` type.
```scala
sealed abstract class Either[+A, +B]
final case class Left[+A, +B](value: A) extends Either[A, B]
final case class Right[+A, +B](value: B) extends Either[A, B]
```
Either has two cases and both of them carry a value. It's a disjoint union of two types. 
When we use it to indicate success or failure, the convention is that `Right` constructor is reserved for a success case, and `Left` is used for failure. 

```scala
def safeDivide(x: Int, y: Int): Either[Throwable, Double] =
  if (y == 0) {
    Left(new IllegalArgumentException("Unable to divide by zero."))
  } else {
    Right(x / y)
  }
```

## Exercise

Make a function that will check user password strength. 
Password must match the following criteria:
- Must contain a minimum of 5 characters
- Must contain one uppercase letter
- Must contain one lowercase letter
- Must contain one number

When you execute the function it must return a valid password or all not satisfied criteria.
Open the object `PasswordChecker` and implement the `validate` method.
After you finish your exercise, run the test to check if it is a success.
```bash
sbt "testOnly *PasswordChecker*"
```
