package com.repaskys.poker

import com.repaskys.poker.Card
import com.repaskys.poker.Hand

import com.repaskys.poker.Player

class Poker {
   Player player1
   Player player2

   public static Poker create(String line) {
      def split = line.split("  ")
      Player pokerPlayer1 = Player.create(split[0])
      Player pokerPlayer2 = Player.create(split[1])
      return new Poker(player1: pokerPlayer1, player2: pokerPlayer2)
   }
}
