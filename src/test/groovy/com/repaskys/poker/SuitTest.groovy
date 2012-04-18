package com.repaskys.poker

import groovy.util.GroovyTestCase

import com.repaskys.poker.Suit

class SuitTest extends GroovyTestCase {
   void testClubs() {
      assert Suit.C.value == "clubs"
   }

   void testHearts() {
      assert Suit.H.value == "hearts"
   }

   void testDiamonds() {
      assert Suit.D.value == "diamonds"
   }

   void testSpades() {
      assert Suit.S.value == "spades"
   }
}
