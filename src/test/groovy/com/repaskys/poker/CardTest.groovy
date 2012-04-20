package com.repaskys.poker

import groovy.util.GroovyTestCase

import com.repaskys.poker.Card
import com.repaskys.poker.Suit

class CardTest extends GroovyTestCase {

   // create our own cards from scratch
   def deuceOfHearts = Card.create("2H")
   def aceOfSpades = Card.create("AS")
   def nineOfClubs = Card.create("9C")

   // pull pre-created cards off of a deck
   def deck = Card.DECK

   void testSuitIsHearts() {
      assert deuceOfHearts.suit.value == "hearts"
   }

   void testDeuceFaceValueIsTwo() {
      assert deuceOfHearts.value == "2"
   }

   void testDeuceHasLowestRank() {
      assert deuceOfHearts.rank == 0
   }

   // in Poker, an Ace ("1") is actually ranked higher than a Deuce ("2")
   void testDeuceIsLowerRankedThanAce() {
      assert deuceOfHearts.rank < aceOfSpades.rank
   }

   void testDeuceIsLowerRankedThanNine() {
      assert deuceOfHearts.rank < nineOfClubs.rank
   }

   void testFaceValueIsNine() {
      assert nineOfClubs.value == "9"
   }

   void testSuitIsClubs() {
      assert nineOfClubs.suit.value == "clubs"
   }

   void testDeckIsFiftyTwoCards() {
      assert deck.size() == 52
   }

   void testDeckDeuceOfHearts() {
      assert deck.get("2H") == deuceOfHearts
   }

   void testDeckAceOfSpades() {
      assert deck.get("AS") == aceOfSpades
   }

   void testDeckNineOfClubs() {
      assert deck.get("9C") == nineOfClubs
   }
}
