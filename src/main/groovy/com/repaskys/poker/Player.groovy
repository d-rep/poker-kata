package com.repaskys.poker

import static com.repaskys.poker.Ranks.*

import com.repaskys.poker.Card
import com.repaskys.poker.Hand

@Immutable
class Player {
   String name
   Hand hand

   private static Hand getHand(cardAbbrs) {
      cardAbbrs.collect{ Card.create(it) } as Hand
   }

   static Player createPlayer(String playerLine) {
      def split = playerLine.split(" ")
      Hand playerHand = Player.getHand(split[1..5])
      new Player(name: split[0], hand: playerHand)
   }
}
