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
    * The values() list from this map will look like this (order may be different):
    * <li>4 of a kind: (4, 1)
    * <li>full house: (3, 2)
    * <li>3 of a kind: (3, 1, 1)
    * <li>2 pairs: (2, 2, 1)
    * <li>1 pair: (2, 1, 1, 1)
    * <li>0 pairs: (1, 1, 1, 1, 1)
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

   /**
    * Determine if the hand contains any of the same ranking cards.
    */
   Pairs ofAKind() {
      def likeCards = groupLikeCards()
      def pairs = null
      def size = likeCards.values().size()

      if(size == 5) {
         pairs = NO_PAIRS
      } else if(size == 2) {

         if(likeCards.containsValue(4)) {
            pairs = FOUR_OF_A_KIND
         } else if(likeCards.containsValue(3) && likeCards.containsValue(2)) {
            pairs = FULL_HOUSE
         }

      } else if(size == 3) {

         if(likeCards.containsValue(3)) {
            pairs = THREE_OF_A_KIND
         } else if(likeCards.containsValue(2)) {
            pairs = TWO_PAIRS
         }

      } else if(size == 4 && likeCards.containsValue(2)) {
         pairs = ONE_PAIR
      }
      return pairs
   }
}
