# Lecture 2: Pure functions

Pure function is a function whose return value entirely depends on its input value, without providing any side effect.
What are side effects? A function has a side effect if it does something other than simply return a result, for example: 
- Mutating a variable that was passed in
- Setting a field on an object outside of a function scope
- Printing to the console or reading user input
- Reading from or writing to a file
- Saving data to a database
- Throwing an exception or halting with an error

The main idea behind functional programming paradigm is to compose the program writing the only pure functions.

## Exercises

In this folder you have two exercises.
In the first exercise you need to guess if function is pure or not.
In the second one you need to make impure functions to be pure.

### Exercise 1: Either pure or not

Open the `EitherPureOrNot.scala` file and try to find which of the defined functions are pure?
If you find out that one of the functions is not pure, try to find the reason why. 


### Exercise 2: Impure to pure

After you successfully finished first exercise, you can open the `EitherPureOrNot.scala` file.
You will find two functions. First one is impure because it updates `participants` field inside the function.
Try to implement pure version of this function (`pureReverse`) without changing its signature.
After you finish your work, you should run test using this command: 
```bash
sbt "testOnly *Impure2Pure*"
```

If the test passes, congratulations, you made it work! 
If the test fails, try to find out what should you do by deeply investigating test case.
