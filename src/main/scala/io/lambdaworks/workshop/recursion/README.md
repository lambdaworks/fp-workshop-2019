# Lecture 4: Recursion

Recursion is a programming technique where a problem solution is described by itself.
In the programming world, it means that one function calls itself. 

Here is a simple example:
```scala
def factorial(n: Int): Int =
  if (n <= 0) 1 else n * factorial(n - 1)
```

Recursive functions should contain two steps: the base case and the recursive case. 
Recursive case is part of a function where function calls itself.
The base case is used to break out the recursive loop. 

## Call stack

A call stack is composed of 1 or many several stack frames.
Each stack frame corresponds to a call to a function which has not yet terminated with a `return`.

For the previously defined `factorial` function, every call will push one stack frame on the call stack.
This keeps on going until the condition for breaking out of recursion is met or the stack memory is full. 
We stop this process when the function enters the base case and its execution generates a return value. 
This return value gets popped out from the stack and passed down to the next steps until all stack frames, that references the same function, are popped out.

The illustration below demonstrates the execution of `factorial` function for argument `3`.

![Stack frame for factorial function][stack-img]  
*Call stack for `factorial(3)` function call (source: How recursion works)*


## Tail call optimization

The previous description of function execution introduces a big condition.
It's said that recursion should overflow the stack memory.
To avoid this problem, we will introduce a tail recursion. 
A tail-recursive function is a function whose return value in the recursive step does not contain any additional computation instead of the function call.  
Because function does not have any additional computation, its call does not provide a new stack frame on the call stack.
This means that before the base condition is executed, we will have only one stack frame instead of `n + 1` frames (*n - number of recursive calls*).

## Exercises

### Exercise 1

Firstly, you should open `TailRecursion` object to see the implementation of the same function in both of recursion ways. 
After that you should run the test:
```bash
sbt "testOnly *TailRecursion*"
``` 

You should see that non-tail implementation will raise a `StackOverflowError` exception, while the tail-recursive one will return value.
 
Note: *If it is not the case on your machine you should decrease stack memory.*

### Exercise 2

Open the `NonTail2TailRecursion` object.
Rewrite `factorial` and `cubesOfEvens` functions to tail-recursive ones. Add the `@tailrec` function annotation to prove that.

## References

 - Beau Carnes, ["How Recursion Works — explained with flowcharts and a video"][how-recursion-works-blog]

[how-recursion-works-blog]:https://www.freecodecamp.org/news/how-recursion-works-explained-with-flowcharts-and-a-video-de61f40cb7f9/
[stack-img]:https://cdn-media-1.freecodecamp.org/images/1*YRkMsMPRFAt8Y9BiC0QVDg.png
