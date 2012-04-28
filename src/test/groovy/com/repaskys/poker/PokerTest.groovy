package com.repaskys.poker

import groovy.util.GroovyTestCase

import com.repaskys.poker.Poker
import static com.repaskys.poker.Ranks.*

class PokerTest extends GroovyTestCase {

   void testLeftBeatsRight() {
      def poker = Poker.create("Left: 2H 4S 4C 2D 4H  Right: 2S 8S AS QS 3S")
      assert poker.player1.hand.rank == FULL_HOUSE
      assert poker.player2.hand.rank == FLUSH
      assert "Left wins." == poker.winner
   }

   void testRightBeatsLeft() {
      def poker = Poker.create("Left: 2H 2S 2C 5D 6H  Right: 2S 3S 4S 5H 6D")
      assert poker.player1.hand.rank == THREE_OF_A_KIND
      assert poker.player2.hand.rank == STRAIGHT
      assert "Right wins." == poker.winner
   }

   void testLeftTiesRight() {
      def poker = Poker.create("Left: 7H 8H 9C QD AH  Right: 7S 8S 9S QH AD")
      assert poker.player1.hand.rank == HIGH_CARD
      assert poker.player2.hand.rank == HIGH_CARD
      assert "Tie." == poker.winner
   }

}
