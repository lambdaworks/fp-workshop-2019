package io.lambdaworks.workshop.immutability
import scala.collection.mutable.ArrayBuffer
import io.lambdaworks.workshop.exceptions.PasswordChecker._

object Immutability {

  final case class Employee(firstName: String, lastName: String) // deeply immutable

  // final case class Task(var title: String, description: Option[String] = None) //mutable because of var field
  final case class Task(title: String, description: Option[String] = None)

  final case class Point(x: Double, y: Double) //immutable

  final case class Polygon(arrayBuffer: ArrayBuffer[Point]) // shallow immutable

  def main(args: Array[String]): Unit = {
    val employee = Employee("John", "Doe")

    // Will not compile
    // employee.firstName = "Peter"

    val updatedEmployee = employee.copy(firstName = "Mike")

    // Will produce false value
    println(updatedEmployee == employee)

    val task = Task("FP", Some("Learn immutability!"))
    // will not compile, reassignment to val
    //    task.title = "Functional programming"

    // Is the List[Task] type mutable?           Yes, because it's a List of mutable type Task. Conditionally Deeply Immutable type.
    // If task is changed to immutable, List[Task] will be immutable too
    val tasks = List[Task](task)
    //    tasks.foreach { task =>
    //      task.title = task.title.toLowerCase
    //    }

    tasks.foreach(println)

    //  Is the Polygon type mutable?            Yes, because ArrayBuffer is mutable type. Shallow immutable
    // A field has a type argument that is known to be mutable or shallow immutable.
    val polygon = Polygon(ArrayBuffer(Point(5, 5), Point(10, 10)))
    polygon.arrayBuffer += Point(15, 15)

    println(polygon)
    println(validate("tek"))
  }
}
