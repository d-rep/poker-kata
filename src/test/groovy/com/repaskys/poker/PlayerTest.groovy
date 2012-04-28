package com.repaskys.poker

import groovy.util.GroovyTestCase

import static com.repaskys.poker.Ranks.*

class PlayerTest extends GroovyTestCase {

   void testParsePlayer() {
      def player = Player.createPlayer("White: 2S 8S AS QS 3S")
      assert player.name == "White:"
      assert player.hand.rank == FLUSH
   }

}
