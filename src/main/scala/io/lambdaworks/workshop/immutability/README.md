# Lecture 1: Immutability

Immutability is the one of the core concepts of the functional programming (also called FP) paradigm. 
Immutability is very important to FP approach because immutable data decreases your chances to write code with side effects. It also ensures concurrency safety and enables you to run your code in parallel.

By default, Scala forces you to write immutable code, but you can still made some mistakes. With this lesson you will learn how to avoid writing mutable code. Maybe it seems to you like it is impossible, but we are going to help you to reach the goal.

Your task is to read `Immutability` object and determine which types are immutable. 
We will use four types of immutability defined for the [Scala immutability plugin][immutability-plugin-url].
Also, think about rewriting mutable types to immutable one.

## Immutable types

Those types are copied from [Scala immutability plugin][immutability-plugin-url].

The definition of an immutable object is an object that has a state that cannot be mutated once instantiated (created).
Immutability can be deep or shallow, i.e. transitive or non-transitive.

### Mutable
We determine a class to have the mutable property if an instance of that class can be mutated directly or indirectly.
A class is determined mutable if:

* The class contains any reassignable field, i.e. a **var** field definition.
* The source code of the class is unknown and unreachable (from this project).
* It inherits a mutable class or mixes in a mutable trait.

The property *mutable* is thus given by only inspecting the fields and the parents of a class.

### Shallow immutable
A class has the shallow (non-transitive) immutable property if the class does not have fields that can be reassigned, but has references to other objects that may be mutated (are shallow immutable or mutable).
The class is determined shallow immutable if:

* The class has only non-reassignable fields, i.e. **val** field definitions.
* Has a parent that is shallow immutable.
* A field has a type that is known to be *mutable* or *shallow immutable*.
* A field has a typeargument that is *mutable* or *shallow immutable*.

### Deeply immutable
A class is deeply (transitive) immutable if all instances of that class cannot be mutated after initialization.
A class is deep immutable if:

* All fields are non-reassignable, i.e. **val** definitions.
* The type of all fields is *deeply immutable*.

All known classes are by default assigned this property until another property holds.

### Conditionally Deeply immutable
The conditionally deeply immutable property is given to a class that is deeply immutable but depends on some other potentially mutable type. An example of this is a generic collection that can store different types, and the collection itself is declared in a way so that it cannot be mutated, but the type that is used with the collection may be *shallow immutable* or *mutable*.
A class has the *conditionally deeply immutable property* if:

* It is *deeply immutable* with one or more type parameters.

[immutability-plugin-url]: https://github.com/luax/scala-immutability-plugin
