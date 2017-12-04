// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.ui;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import upmc.pcg.game.Player;

/**
 * Contains methods used in the UI for the game
 *
 * @author Nicolas BOULLET
 */
public class GameUI {
    private static Scanner scan;
    
    /**
     * Explicit
     */
    public static HashMap<String, Player> createPlayers() {
        HashMap<String, Player> players = new HashMap<>();
        
        //Creation of players : user and an IA
        players.put("user", new Player(askPlayerName()));
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
        printAskCard();
    }
    
    private void printAskCard() {
        
    }
    
    /**
     * Generate a random Integer between min and max
     */
    public static Integer generateRandomInt(int min, int max) {
        Integer result = null;
        Random random = new Random();
        
        if(min<max) {
            result = random.nextInt(max - min + 1) + min;
        }
        
        return result;
    }
}