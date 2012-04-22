package com.repaskys.poker

import static com.repaskys.poker.Pairs.*

@Immutable
class Hand extends ArrayList<Card> {

   boolean isFlush() {
      // Get the "suit" property of every item, put it in a Set to ensure we only
      // keep uniques, then make sure that collection contains only one item.
      return (this*.suit as Set).size() == 1
   }

   /**
    * Group any cards that have the same face value, which is used to determine pairs.
    * Entries in the map have a key with the face value of the card and a value containing the amount of matches.
    */
   Map<String, Integer> groupLikeCards() {

      def likeCards = [:]

      this.each{ card ->
         def value = card.value
         def matches = likeCards[value]
         if(matches == null) {
            matches = 0
         }
         likeCards[value] = matches + 1
      }

      return likeCards
   }

   Pairs ofAKind() {
      def likeCards = groupLikeCards()
      def pairs = THREE_OF_A_KIND

      if(likeCards.containsValue(4)) {
         pairs = FOUR_OF_A_KIND
      }
      return pairs
   }
}
