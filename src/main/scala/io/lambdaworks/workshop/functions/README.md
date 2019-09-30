# Lecture 5: `map/filter/reduce` functions

## Map 

> In many programming languages, `map` is the name of a higher-order function that applies a given function to each element of a [functor][functor]. 
> For this example we will explain its usage on the list functor. 

Example:
```scala
def square(numbers: Seq[Int]): Seq[Int] = numbers.map(n => n * n)

val result = square(Seq(2, 4, 7)) // result: Seq(4, 16, 49)
```

## Filter

> In functional programming, filter is a higher-order function that processes a data structure (usually a list) in some order to produce a new data structure containing exactly those elements of the original data structure for which a given predicate returns the `Boolean` value `true`.

Example:
```scala
def even(numbers: Seq[Int]): Seq[Int] = numbers.filter(_ % 2 == 0)

val result = even(Seq(2, 9, 4, 1)) // result: Seq(2, 4)
```

## Reduce

> In functional programming, `fold` (also termed `reduce`, `accumulate`, `aggregate`, `compress`, or `inject`) refers to a family of higher-order functions that analyze a recursive data structure and through use of a given combining operation, recombine the results of recursively processing its constituent parts, building up a return value.

Example:
```scala
def sum(numbers: Seq[Int]): Seq[Int] = numbers.reduce(_ + _)

val result = sum(Seq(4, 1, 3, 7)) // result: 15
```


## Exercise

Your task is to create a function that will translate words from a sentence into emojis.
Note that punctuation marks should make you a problem, so remove them from the sentences.

Sentence  
```A house without a cat or a little child is a house without joy or laughter.```  
should be converted to  
```🅰 🏠 without 🅰 🐱 or 🅰 little child is 🅰 🏠 without 😂 or laughter```

You have a `EmojifyText` object where you should implement your solution. 
There are defined two useful functions that should you help to implement `emojify` function. 
Force yourself to use all explained functions from this lesson (`map/filter/reduce`).
To test your result run
```bash
sbt "testOnly *EmojifyText*"
```

[functor]:https://typelevel.org/cats/typeclasses/functor.html