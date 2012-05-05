" This is a vim session file which will open all the source code for this
" project in separate editor tabs.  To use it, you can type the following inside of
" gvim:
"
":source Session.vim
"
" OR boot up gvim from the command line like this...
" gvim -S
"
:cd src/main/groovy/com/repaskys/poker/
:e Card.groovy
:tabnew Hand.groovy
:tabnew Player.groovy
:tabnew Poker.groovy
:tabnew Ranks.groovy
:tabnew Suit.groovy
:cd -
:cd src/test/groovy/com/repaskys/poker/
:tabnew CardTest.groovy
:tabnew HandTest.groovy
:tabnew PlayerTest.groovy
:tabnew PokerTest.groovy
:tabnew RanksTest.groovy
:tabnew SuitTest.groovy
:cd -
:cd src/test/resources
:tabnew input.txt
:tabnew output.txt
:cd -
