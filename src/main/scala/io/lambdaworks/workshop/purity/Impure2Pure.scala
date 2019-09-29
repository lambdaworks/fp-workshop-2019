package io.lambdaworks.workshop.purity

object Impure2Pure {

  final case class Participant(firstName: String, lastName: String, score: Int)

  final case class RankingTable(var participants: Seq[Participant])

  /** Make this function pure.
    * Run the tests with `sbt "testOnly *Impure2Pure*"` to prove that it is pure.
    */
  def reverse(table: RankingTable): RankingTable = {
    var result = Seq[Participant]()

    for (index <- table.participants.length - 1 to 0 by -1) {
      result :+= table.participants(index)
    }
    table.participants = result

    table
  }

  def pureReverse(table: RankingTable): RankingTable = ???

}
