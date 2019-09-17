# Functional programming workshop

This is simple sbt project that demonstrates basic principles of functional programming paradigm. 
Project is prepared for introduction to functional programming workshop as part of conEEct 2019 conference.

## Who should join?

We will try to intrigue you to learn popular concepts of FP paradigm. If you are new to FP and 
you don't know where to start you should use this repository to learn basic concepts of FP. 
Also, you should be able to test yourself by doing some simple tests after every lesson. 

## What will you learn?

We will cover basic concepts of the functional programming and its advantages and disadvantages. 
You should learn where you should apply your FP knowledge and how it should help you to write more testable,
readable and elegant code.

Main topics that are covered within this repository:
 - Immutability
 - Pure functions
 - First functions
 - Tail recusrion
 - `map`/`filte`/`reduce` functions

## Where to start?

Project is written in `Scala` programming language and it uses `sbt` as build tool.
 
To start working on this project you need to go through those steps:
 - Install sbt
   
   You should follow instructions from this [link](https://www.scala-sbt.org/0.13/docs/Setup.html) 
 
 - Clone the workshop repository
 
   ```bash
   git clone [link to repo]
   ``` 
   
   You should feel free to fork repository and work on your own copy. Also if you think that you should improve
   this workshop you should send us a pull request with concrete updates. We would be happy to consider its merging.
    
 - Running the project
    
   To run the project you should type `sbt run` and choose which program you want to run. 
   If you want to automatically choose the specific class you should run for example.
   ```
   sbt "runMain io.lambdaworks.workshop.immutability.Immutability"
   ```
   
   The only requirement is that the specified class has main method.
   
 - Every package covers different topic and has `README.md` file where you should find useful instructions.
 - At the end of the course, you should run tests to check your results. Type command `sbt test` in the root folder of the project.
   

 
## References

 - Paul Chiusano and Runar Bjarnason, "Functional programming in Scala", Manning Publications, 2014


