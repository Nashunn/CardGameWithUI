// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.ui;

import java.util.HashMap;
import java.util.Random;
import upmc.pcg.game.Player;

/**
 * Contains methods used in the UI for the game
 *
 * @author Nicolas BOULLET
 */
public class GameUI {
    
    /**
     * Generate a random Integer between min and max
     */
    public static Integer generateRandomInt(int min, int max) {
        Integer result = null;
        Random random = new Random();
        
        if(min<=max) {
            result = random.nextInt(max - min + 1) + min;
        }
        
        return result;
    }
    
    /**
     * Explicit
     */
    public static HashMap<String, Player> createPlayers() {
        HashMap<String, Player> players = new HashMap<>();
        
        //Creation of players : user and an IA
        //players.put("user", new Player(askPlayerName()));
        players.put("user", new Player("You"));
        players.put("IA", new Player(true));
        
        return players;
    }
    
    /**
     * Ask the player which name he wants to use
     */
    public static String askPlayerName() {
        String result = "";
        
        do {
            result = Console.askString("What's your pseudo ? ");
        }while(result == "");
        
        return result;
    }
    
    /**
     * Ask the user to set a card as an active card
     * and put one of the card in the IA's hand as active too
     */
    public static void askCard(Player user, Player IA) {
        int chosenCardId = -1;
        Console.printTitle("Play a card");
        
        chosenCardId = MenuUI.printAskCard(user);
        
        user.playCard(chosenCardId-1);
        IA.playCard(GameUI.generateRandomInt(0, IA.nbCardHand()-1));       
    }
    
    /**
     * Explicit
     */
    public static void printResultOfBattle(Player user, Player IA, int resultBattle) {
        String userCard = user.getActiveCard().toString();
        String enemyCard = IA.getActiveCard().toString();
        
        Console.printTitle("Result of battle");
        System.out.println(userCard+"("+user.printName()+") VS "+enemyCard+"("+IA.printName()+")");
        printWinnerBattle(user, IA, resultBattle);
        
        Console.waitEnter();
    }
    
    /**
     * Print the winner after a switch with the result of the battle
     */
    private static void printWinnerBattle(Player user, Player IA, int resultBattle) {
        switch(resultBattle) {
            case 1:
                System.out.println(user.printName()+" has won this battle!");
                break;
            case -1:
                System.out.println(IA.printName()+" has won this battle!");
                break;
            default:
                System.out.println("It's a draw !");
                break;
        }
    }
    
    /**
     * Explicit
     */
    public static void printEndOfTurn(Player user, Player IA) {
        Console.printTitle("End of turn");
        System.out.println("\nScore : "+user.toString()+" | "+IA.toString()+"\n");
    }
    
    /**
     * Explicit
     */
    public static void printEndGame(Player user, Player IA) {
        Console.printTitle("END OF THE GAME");
        System.out.println(MenuUI.printScore(user, IA));
        
        if(user.getGiveUp())
           System.out.println("The IA won, because you give up !");
        else {
            if(user.getScore()>IA.getScore())
                System.out.println("You won !");
            else if(user.getScore()<IA.getScore())
                System.out.println("The IA won !");
            else
                System.out.println("No winner for this time !");
        }
    }
}