package com.repaskys.poker

import groovy.util.GroovyTestCase

import static com.repaskys.poker.Card.DECK as D
import static com.repaskys.poker.Ranks.*

import com.repaskys.poker.Hand
import com.repaskys.poker.Suit

class HandTest extends GroovyTestCase {

   def handStraightFlush = [D."9C", D."TC", D."JC", D."QC", D."KC"] as Hand
   def handFlush = [D."2C", D."3C", D."4C", D."5C", D."8C"] as Hand
   def handStraight = [D."2C", D."3C", D."4C", D."5C", D."6D"] as Hand
   def handFourOfAKind = [D."2C", D."2S", D."2D", D."2H", D."8D"] as Hand
   def handFullHouse = [D."2C", D."2S", D."3D", D."3H", D."3D"] as Hand
   def handThreeOfAKind = [D."2C", D."2S", D."2D", D."3H", D."8D"] as Hand
   def handTwoPairs = [D."2C", D."2S", D."3D", D."3H", D."8D"] as Hand
   def handOnePair = [D."2C", D."2S", D."3D", D."4H", D."8D"] as Hand
   def handHighCardEight = [D."2C", D."3S", D."4D", D."6H", D."8D"] as Hand
   def handHighCardEightDifferentSuits = [D."2D", D."3C", D."4S", D."6D", D."8S"] as Hand
   def handHighCardKing = [D."2C", D."3S", D."4D", D."6H", D."KD"] as Hand

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

   void testRankHighCard() {
      assert HIGH_CARD == handHighCardEight.rank
   }

   void testRankOnePair() {
      assert ONE_PAIR == handOnePair.rank
   }

   void testRankTwoPairs() {
      assert TWO_PAIRS == handTwoPairs.rank
   }

   void testRankThreeOfAKind() {
      assert THREE_OF_A_KIND == handThreeOfAKind.rank
   }

   void testRankStraight() {
      assert STRAIGHT == handStraight.rank
   }

   void testRankFlush() {
      assert FLUSH == handFlush.rank
   }

   void testRankFullHouse() {
      assert FULL_HOUSE == handFullHouse.rank
   }

   void testRankFourOfAKind() {
      assert FOUR_OF_A_KIND == handFourOfAKind.rank
   }

   void testRankStraightFlush() {
      assert STRAIGHT_FLUSH == handStraightFlush.rank
   }

   void compareTie() {
      assert handHighCardEight == handHighCardEightDifferentSuits
      assert handHighCardEight.highCard == null
   }

   void compareHighCardLeftWins() {
      assert handHighCardAce > handHighCardEight
      assert handHighCardAce.highCard == "A"
   }

   void compareHighCardRightWins() {
      assert handHighCardEight < handHighCardAce
      assert handHighCardAce.highCard == "A"
   }

   void testHandOrderDoesntMatter() {
      def handStraightFlushScrambled = [D."QC", D."JC", D."KC", D."9C", D."TC"] as Hand
      assert STRAIGHT_FLUSH == handStraightFlushScrambled.rank
   }

   void testHandSortedByRank() {
      def handStraightFlushScrambled = [D."QC", D."JC", D."KC", D."9C", D."TC"] as Hand
      assert handStraightFlush == handStraightFlushScrambled.sort()
   }


}
