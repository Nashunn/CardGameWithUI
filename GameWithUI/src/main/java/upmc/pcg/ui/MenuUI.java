// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.ui;

import upmc.pcg.game.Hand;
import upmc.pcg.game.Player;

/**
 * Contains methods about menu for the UI
 *
 * @author Nicolas BOULLET
 */
public class MenuUI {
   
    /**
    * Return a boolean that indicate if the user
    * wants to launch the game
    */ 
    public static boolean launcherMenu() {
        boolean launchGame = false;
        
        Console.printSeparator();
        System.out.println("ELEMENTAL BATTLE");
        launchGame = askLauncherMenu();
        Console.printSeparator();
        
        return launchGame;
    }
    
    /**
     * Ask the player what actions he wants to do in the launcher menu 
     */
    private static boolean askLauncherMenu() {
        boolean launchGame = false;
        Integer response = 0;
        
        System.out.println("\n 1. Play\n 2. Quit");
        do {
            response = Console.askInt("What do you want to do ?");
        }while (response==null || response<1 || response>2);
        
        if(response == 1)
            launchGame = true;
        
        return launchGame;
    }
    
    /**
     * Print a message when the user quit the game
     */
    public static void printQuitGame() {
        System.out.println("Thank you for playing !\nGuitting the game..\n\n");
    }
    
    /**
     * Print messages to ask the player what card he wants to play
     */
    public static Integer printAskCard(Player player) {
        System.out.println("What card do you want to play ?\n");
        System.out.println("Cards in your hand :");
        System.out.println(player.listHand());
        
        return chosenCardInHand();
    }
    
    /**
     * Get the id of the chosen card from the player's hand
     */
    private static Integer chosenCardInHand() {
        Integer result = -1;
        
        do {
            result = Console.askInt("Chose your card for the battle : ");
        }while(result==null || result<=0 || result>Hand.MAX_SIZE);
        
        return result;
    }
}