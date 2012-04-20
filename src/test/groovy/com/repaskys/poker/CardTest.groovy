package com.repaskys.poker

import groovy.util.GroovyTestCase

import com.repaskys.poker.Card
import com.repaskys.poker.Suit

class CardTest extends GroovyTestCase {

   void testDeuceOfHearts() {
      def card = Card.create("2H")
      assert card.value == "2"
      assert card.suit.value == "hearts"
      // a duece has the lowest rank
      assert card.rank == 0
   }

   void testNineOfClubs() {
      def card = Card.create("9C")
      assert card.value == "9"
      assert card.suit.value == "clubs"
      assert card.rank == 7
   }

   void testDeck() {
      def deck = Card.DECK
      assert deck.size() == 52
      assert deck.get("2C").value == "2"
      assert deck.get("2C").suit.value == "clubs"
      assert deck.get("2C").suit == Suit.C
      assert deck.get("2C").rank == 0
   }

}
