package com.repaskys.poker

import static com.repaskys.poker.Ranks.*

import groovy.util.GroovyTestCase

class RanksTest extends GroovyTestCase {
   void testCompareAllRanks() {
      assert STRAIGHT_FLUSH > FOUR_OF_A_KIND
      assert FOUR_OF_A_KIND > FULL_HOUSE
      assert FULL_HOUSE > STRAIGHT
      assert STRAIGHT > THREE_OF_A_KIND
      assert THREE_OF_A_KIND > TWO_PAIRS
      assert TWO_PAIRS > ONE_PAIR
      assert ONE_PAIR > NO_PAIRS
      assert ONE_PAIR > HIGH_CARD
   }
}
