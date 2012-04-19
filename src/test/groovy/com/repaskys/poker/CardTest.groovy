package com.repaskys.poker

import groovy.util.GroovyTestCase

import com.repaskys.poker.Card
import com.repaskys.poker.Suit

class CardTest extends GroovyTestCase {

   void testDeuceOfHearts() {
      // pass in raw enum
      def card = Card.create("2H")
      assert card.value == "2"
      assert card.suit.value == "hearts"
   }

   void testNineOfClubs() {
      // pass in string instead of enum
      def card = Card.create("9C")
      assert card.value == "9"
      assert card.suit.value == "clubs"
   }

}
