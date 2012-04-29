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

   public String getWinner() {
      String winner = "Tie"

      def hand1 = player1.hand
      def hand2 = player2.hand

      if(hand1 > hand2) {
         winner = "${player1.name} wins with ${hand1.rank.text}"
      } else if(hand1 < hand2) {
         winner = "${player2.name} wins with ${hand2.rank.text}"
      }
      return winner
   }
}
