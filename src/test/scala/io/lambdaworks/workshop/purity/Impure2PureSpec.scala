package io.lambdaworks.workshop.purity

import io.lambdaworks.workshop.UnitSpec
import io.lambdaworks.workshop.purity.Impure2Pure.{Participant, RankingTable, pureReverse}

final class Impure2PureSpec extends UnitSpec {
  "Reverse function" when {
    "calling on the same ranking table twice" should {
      "return participants in the same order" in {
        val participants = Seq(
          Participant("Greg", "Sottell", 7),
          Participant("John", "Pawden", 8),
          Participant("Peter", "Henrych", 10)
        )

        val table         = RankingTable(participants)
        val reversedTable = RankingTable(participants.reverse)

        pureReverse(table) mustBe reversedTable
        pureReverse(table) mustBe reversedTable
      }
    }
  }
}
