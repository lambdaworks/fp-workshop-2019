package io.lambdaworks.workshop.firstclass

object Drop {

  /**
    * Implement function that should drop elements that satisfy predicate function(p)
    * Implementation should pass suite DropFCFSpec
    */
  def dropIf[A](elements: List[A], p: A => Boolean): List[A] = {
    val res = elements
    res.filter(x => !p(x))
  }

}
