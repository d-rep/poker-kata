package com.repaskys.poker

import groovy.util.GroovyTestCase

import static com.repaskys.poker.Card.DECK as D
import static com.repaskys.poker.Ranks.*

import com.repaskys.poker.Hand
import com.repaskys.poker.Suit

class HandTest extends GroovyTestCase {

   void testFlush() {
      def hand = [D."2C", D."3C", D."4C", D."5C", D."8C"] as Hand
      assert hand.isFlush()
   }

   void testNotFlush() {
      def hand = [D."2C", D."3C", D."4C", D."5C", D."8D"] as Hand
      assert ! hand.isFlush()
   }

   void testStraight() {
      def hand = [D."2C", D."3C", D."4C", D."5C", D."6D"] as Hand
      assert hand.isStraight()
   }

   void testNotStraight() {
      def hand = [D."2C", D."3C", D."4C", D."5C", D."7D"] as Hand
      assert ! hand.isStraight()
   }

   void testGroupLikeCardsNoPairs() {
      def hand = [D."2C", D."3C", D."4C", D."5C", D."8D"] as Hand
      assert ["2":1, "3":1, "4":1, "5":1, "8":1] == hand.groupLikeCards()
   }

   void testGroupLikeCardsFourOfAKind() {
      def hand = [D."2C", D."2S", D."2D", D."2H", D."8D"] as Hand
      assert ["2":4, "8":1] == hand.groupLikeCards()
   }

   void testGroupLikeCardsThreeOfAKind() {
      def hand = [D."2C", D."2S", D."2D", D."3H", D."8D"] as Hand
      assert ["2":3, "3":1, "8":1] == hand.groupLikeCards()
   }

   void testGroupLikeCardsTwoPairs() {
      def hand = [D."2C", D."2S", D."3D", D."3H", D."8D"] as Hand
      assert ["2":2, "3":2, "8":1] == hand.groupLikeCards()
   }

   void testGroupLikeCardsOnePair() {
      def hand = [D."2C", D."2S", D."3D", D."4H", D."8D"] as Hand
      assert ["2":2, "3":1, "4":1, "8":1] == hand.groupLikeCards()
   }

   void testNoMatchingCardsOfAKind() {
      def hand = [D."2C", D."3C", D."4C", D."5C", D."8D"] as Hand
      assert NO_PAIRS == hand.ofAKind()
   }

   void testFourOfAKind() {
      def hand = [D."2C", D."2S", D."2D", D."2H", D."8D"] as Hand
      assert FOUR_OF_A_KIND == hand.ofAKind()
   }

   void testFullHouse() {
      def hand = [D."2C", D."2S", D."3D", D."3H", D."3D"] as Hand
      assert FULL_HOUSE == hand.ofAKind()
   }

   void testThreeOfAKind() {
      def hand = [D."2C", D."2S", D."2D", D."3H", D."8D"] as Hand
      assert THREE_OF_A_KIND == hand.ofAKind()
   }

   void testTwoPairs() {
      def hand = [D."2C", D."2S", D."3D", D."3H", D."8D"] as Hand
      assert TWO_PAIRS == hand.ofAKind()
   }

   void testOnePair() {
      def hand = [D."2C", D."2S", D."3D", D."4H", D."8D"] as Hand
      assert ONE_PAIR == hand.ofAKind()
   }

}
