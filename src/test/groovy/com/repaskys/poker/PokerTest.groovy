package com.repaskys.poker

import groovy.util.GroovyTestCase

import com.repaskys.poker.Poker
import static com.repaskys.poker.Ranks.*

class PokerTest extends GroovyTestCase {

   void testLeftBeatsRight() {
      def poker = Poker.create("Left: 2H 4S 4C 2D 4H  Right: 2S 8S AS QS 3S")
      assert poker.player1.hand.rank == FULL_HOUSE
      assert poker.player2.hand.rank == FLUSH
      assert "Left wins with a full house" == poker.winner
   }

   void testRightBeatsLeft() {
      def poker = Poker.create("Left: 2H 2S 2C 5D 6H  Right: 2S 3S 4S 5H 6D")
      assert poker.player1.hand.rank == THREE_OF_A_KIND
      assert poker.player2.hand.rank == STRAIGHT
      assert "Right wins with a straight" == poker.winner
   }

   void testLeftTiesRight() {
      def poker = Poker.create("Left: 7H 8H 9C QD AH  Right: 7S 8S 9S QH AD")
      assert poker.player1.hand.rank == HIGH_CARD
      assert poker.player2.hand.rank == HIGH_CARD
      assert "Tie" == poker.winner
   }

   void testLeftBeatsRightWithHighCard() {
      def poker = Poker.create("Left: 7H 8H 9C QD KH  Right: 7S 8S 9S TH KD")
      assert poker.player1.hand.rank == HIGH_CARD
      assert poker.player2.hand.rank == HIGH_CARD
      assert "Left wins with high card Q" == poker.winner
   }

   void testLeftTiesRightWithEqualPair() {
      def poker = Poker.create("Left: 7H 8H 9C KD KH  Right: 7S 8S 9S KC KS")
      assert poker.player1.hand.rank == ONE_PAIR
      assert poker.player2.hand.rank == ONE_PAIR
      assert "Tie" == poker.winner
   }

   void testHigherPairWins() {
      def poker = Poker.create("Left: 7H 8H 9C KD KH  Right: 7S 8S TS QC QS")
      assert poker.player1.hand.rank == ONE_PAIR
      assert poker.player2.hand.rank == ONE_PAIR
      assert "Left wins with one pair" == poker.winner
   }

   void testSameRankedPairHasTieBreakerHighCard() {
      def poker = Poker.create("Left: 7H 8H 9C KD KH  Right: 7S 8S TS KC KS")
      assert poker.player1.hand.rank == ONE_PAIR
      assert poker.player2.hand.rank == ONE_PAIR
      assert "Right wins with one pair" == poker.winner
   }

   void testWithFile() {
      def input = []
      def expectedOutput = []
      new File("src/test/resources/input.txt").eachLine{ line ->
         input.add(line)
      }
      new File("src/test/resources/output.txt").eachLine{ line ->
         expectedOutput.add(line)
      }
      int index = 0
      input.each{
         def poker = Poker.create(it)
         assert expectedOutput[index++] == poker.winner
      }
   }
}
