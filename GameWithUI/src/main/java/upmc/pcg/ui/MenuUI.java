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
        
        Console.printTitle("ELEMENTAL BATTLE");
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
        
        System.out.println(" 1. Play\n 2. Info\n 3. Quit");
        do {
            response = Console.askInt("What do you want to do ?");
        }while (response==null || response<1 || response>3);
        
        if(response == 1 || response == 2)
            launchGame = true;
        if(response == 2)
            printInfo();
        
        return launchGame;
    }
    
    /**
     * Print info about the game and its rules
     */
    public static void printInfo() {
        Console.printTitle("Information");
        System.out.println(
            "This game is based on the same principles as a classic battle.\n"+
            "You and your opponent chose a card in your hand, and the one with the higher number on it win.\n\n"+
            "But on the top of that some elemental rules are added :\n"+
            " If your card element is the weakness of the other, the number on your card is up by one\n\n"+
            "List of weakness : Water > Fire > Plant > Air > Water"
        );
        Console.waitEnter();
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
    
    /**
     * Ask the user what action he wants to do at the end of the turn
     * Return : 
     * - true if the user wants to quit the game
     * - false if the user want to continue
     */
    public static boolean endOfTurn(Player user, Player IA) {
        boolean quitGame = false;
        
        if(!user.isHandEmpty() && !IA.isHandEmpty()) {
            GameUI.printEndOfTurn(user, IA);
            quitGame = askActionEndTurn(user);
        }
        else
            quitGame = true;
        
        return quitGame;
    }
    
    /**
     * Explicit, see MenuiUI.endOfTurn()
     */
    private static boolean askActionEndTurn(Player user) {
        String response = "";
        boolean quitGame = false;

        System.out.println("Do you want to :\n - Continue(press enter)\n - Give up(press q+enter)?\n");
        
        do {
            response = Console.askString("Your choice ?\n");
        }while(!response.equals("") && !response.equals("q"));
        
        if(response.equals("q")) {
            user.giveUp();
            quitGame = true;
        }   
        
        return quitGame;
    }
    
    /**
     * Return the score in the form of a string
     */
    public static String printScore(Player user, Player IA) {
        return user.toString()+" | "+IA.toString();
    }
}