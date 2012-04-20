package com.repaskys.poker

@Immutable
class Hand extends ArrayList<Card> {
   boolean isFlush() {
      // get the "suit" property of every item, put it in a Set to ensure we only keep uniques, then make sure that collection contains only one item
      return (this*.suit as Set).size() == 1
   }
}
