package com.repaskys.poker

import com.repaskys.poker.Card
import com.repaskys.poker.Hand
import com.repaskys.poker.Player

import static com.repaskys.poker.Ranks.*

class Poker {
   Player player1
   Player player2

   public static Poker create(String line) {
      def split = line.split("  ")
      Player pokerPlayer1 = Player.create(split[0])
      Player pokerPlayer2 = Player.create(split[1])
      return new Poker(player1: pokerPlayer1, player2: pokerPlayer2)
   }

   def winnerText(Player player) {
      def rank = player.hand.rank
      def highCard = player.hand.highCard
      String tieBreaker = (HIGH_CARD == rank && highCard != null) ? " ${highCard}" : ""
      "${player.name} wins with ${rank.text}${tieBreaker}"
   }

   public String getWinner() {
      def winner = "Tie"
      if(player1.hand > player2.hand) {
         winner = winnerText(player1)
      } else if(player1.hand < player2.hand) {
         winner = winnerText(player2)
      }
      return winner
   }
}
