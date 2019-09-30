package io.lambdaworks.workshop.functions

import java.net.URL

import io.lambdaworks.workshop.functions.UsefulFunctions.Course.Course

import scala.util.Try

object UsefulFunctions {

  object Course extends Enumeration {
    type Course = Value
    val Archaeology, ComputerScience, Geography, FineArt = Value
  }

  final case class Participant(
      firstName: String,
      lastName: String,
      score: Int,
      course: Course,
      age: Int
  )

  def studentNames(students: Seq[Participant]): Seq[String] =
    students.map(student => s"${student.firstName} ${student.lastName}")

  def url2Hosts(urls: Seq[String]): Seq[String] =
    urls.flatMap(s => Try(new URL(s)).toOption).map(_.getHost)

  def square(numbers: Seq[Int]): Seq[Int] =
    numbers.map(n => n * n)

  def findEven(numbers: Seq[Int]): Seq[Int] =
    numbers.filter(_ % 2 == 0)

  def studentsThatPassed(students: Seq[Participant]): Seq[Participant] =
    students.filterNot(_.score < 80)

  // filter(...).length should be replaced with count(...)
  def wordsLongerThan(text: Seq[String], length: Int): Int =
    text.filter(_.length == length).length

  // It will fail for empty list
  def makeSentence(words: Seq[String]): String =
    words.reduce(_ + _)

  // fold(0)(_ + _) should be replaced with sum also
  def overallScore(students: Seq[Participant]): Int =
    students.map(_.score).fold(0)(_ + _) / students.length

  def geographyOverallAge(students: Seq[Participant]): Int =
    students.filter(_.course == Course.Geography).map(_.age).fold(0)(_ + _)

}
