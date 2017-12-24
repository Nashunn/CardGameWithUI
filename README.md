# CardGame with UI

This game is based on the same principles as a classic battle.

But on the top of that some elemental rules are added :
    - If your card element is the weakness of the other, the number on your card is up by one
    - List of weakness : Water > Fire > Plant > Air > Water 

Principles
============

You and your opponent chose a card in your hand, and the one with the higher number on it win.
The game continue until each player's deck are empty.

Instructions
============

Compile the game with `mvn compile`.

Launch a game with the command line `mvn exec:java -Dexec.mainClass="upmc.pcg.CardGameWithUI"`
