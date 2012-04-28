package com.repaskys.poker

import groovy.util.GroovyTestCase

import com.repaskys.poker.Poker
import static com.repaskys.poker.Ranks.*

class PokerTest extends GroovyTestCase {

   void testParseLine() {
      def line = "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S"
      def poker = Poker.create(line)
      assert poker.player1.hand.rank == FULL_HOUSE
      assert poker.player2.hand.rank == FLUSH
   }
}
