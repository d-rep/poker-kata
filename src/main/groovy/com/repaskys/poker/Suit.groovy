package com.repaskys.poker

enum Suit {
   C("clubs"),
   D("diamonds"),
   H("hearts"),
   S("spades");

   def value
   Suit(description) {
      value = description
   }

}
