package com.repaskys.poker

import groovy.util.GroovyTestCase

import static com.repaskys.poker.Card.DECK as D
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
}
