package com.repaskys.poker

/**
 * Represents the different Poker hand rankings.
 * "No Pairs" and "High Card" are the same, but the former is returned after 
 * checking for pairs, and the latter when evaluating for every hand ranking
 */
enum Ranks {
   HIGH_CARD,
   NO_PAIRS,
   ONE_PAIR,
   TWO_PAIRS,
   THREE_OF_A_KIND,
   STRAIGHT,
   FLUSH,
   FULL_HOUSE,
   FOUR_OF_A_KIND,
   STRAIGHT_FLUSH;
}
