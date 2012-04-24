package com.repaskys.poker

import groovy.util.GroovyTestCase

import static com.repaskys.poker.Card.DECK as D
import static com.repaskys.poker.Ranks.*

import com.repaskys.poker.Hand
import com.repaskys.poker.Suit

class HandTest extends GroovyTestCase {

   def handFlush = [D."2C", D."3C", D."4C", D."5C", D."8C"] as Hand
   def handStraight = [D."2C", D."3C", D."4C", D."5C", D."6D"] as Hand
   def handFourOfAKind = [D."2C", D."2S", D."2D", D."2H", D."8D"] as Hand
   def handFullHouse = [D."2C", D."2S", D."3D", D."3H", D."3D"] as Hand
   def handThreeOfAKind = [D."2C", D."2S", D."2D", D."3H", D."8D"] as Hand
   def handTwoPairs = [D."2C", D."2S", D."3D", D."3H", D."8D"] as Hand
   def handOnePair = [D."2C", D."2S", D."3D", D."4H", D."8D"] as Hand

   void testFlush() {
      assert handFlush.isFlush()
   }

   void testNotFlush() {
      assert ! handStraight.isFlush()
   }

   void testStraight() {
      assert handStraight.isStraight()
   }

   void testNotStraight() {
      assert ! handFlush.isStraight()
   }

   void testGroupLikeCardsNoPairs() {
      assert ["2":1, "3":1, "4":1, "5":1, "8":1] == handFlush.groupLikeCards()
   }

   void testGroupLikeCardsFourOfAKind() {
      assert ["2":4, "8":1] == handFourOfAKind.groupLikeCards()
   }

   void testGroupLikeCardsThreeOfAKind() {
      assert ["2":3, "3":1, "8":1] == handThreeOfAKind.groupLikeCards()
   }

   void testGroupLikeCardsTwoPairs() {
      assert ["2":2, "3":2, "8":1] == handTwoPairs.groupLikeCards()
   }

   void testGroupLikeCardsOnePair() {
      assert ["2":2, "3":1, "4":1, "8":1] == handOnePair.groupLikeCards()
   }

   void testNoMatchingCardsOfAKind() {
      assert NO_PAIRS == handFlush.ofAKind()
   }

   void testFourOfAKind() {
      assert FOUR_OF_A_KIND == handFourOfAKind.ofAKind()
   }

   void testFullHouse() {
      assert FULL_HOUSE == handFullHouse.ofAKind()
   }

   void testThreeOfAKind() {
      assert THREE_OF_A_KIND == handThreeOfAKind.ofAKind()
   }

   void testTwoPairs() {
      assert TWO_PAIRS == handTwoPairs.ofAKind()
   }

   void testOnePair() {
      assert ONE_PAIR == handOnePair.ofAKind()
   }

}
