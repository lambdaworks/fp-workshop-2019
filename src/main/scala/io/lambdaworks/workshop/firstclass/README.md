# Lecture 3: First-class functions

> One of the core values of functional programming is that functions should be first-class.
> The term indicates that they are not only declared and invoked but can be used in every segment of the language as just another data type.
> A first-class function may, as with other data types, be created in literal form without ever having been assigned an identifier; be stored in a container such as a value, variable, or data structure; and be used as a parameter to another function or used as the return value from another function.
>
> -- <cite>[Learning Scala][learning-scala]</cite>

First-class functions are important for the functional programming because they are infallible part of function composition.
Without this concept we would not be able to make one function by composing two ore more functions.

Also, languages that threat functions as the first-class values has one another term, high-order function.
High-order function is a function that accepts another function as an argument or it returns function as a result.

You should open file `FirstClassFunctions.scala` and see real examples of high-order functions implemented in Scala. 

## Exercise: Drop if 

In the `DropFCF.scala` file you should find one exercise where you should implement `dropIf` function without changing its signature.
The function should accept list of elements as argument and drop all elements that satisfy the predicate function `p`. 

After you finish your work, you should run test using this command: 
```bash
sbt "testOnly *Drop*"
```

If the test passes, congratulations, you made it work! 
If the test fails, try to find out what should you do by deeply investigating test case.

[learning-scala]: https://www.oreilly.com/library/view/learning-scala/9781449368814/
