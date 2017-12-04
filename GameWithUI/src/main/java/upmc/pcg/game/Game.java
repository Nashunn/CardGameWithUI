// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.game;

import java.util.HashMap;
import upmc.pcg.ui.GameUI;

/**
 * Class that contains methods to run the game
 *
 * @author Nicolas BOULLET
 */
public class Game {
    private HashMap<String, Player> players;
    private boolean boolQuitGame = false;
    private int resultBattle = 0;
    
    /**
     * Initialize parameters for the game
     */
    public void initialize() {
        players = GameUI.createPlayers();
        giveDeckToEachPlayer();
    }
    
    /**
     * Launch the game
     */
    public void play() {        
        do {
            fillHands();
            GameUI.askCard(getUser(), getIA());
            resultBattle = cardBattle(getUser(), getIA());
            
            //to remove
            boolQuitGame = true;
        } while(!boolQuitGame);
    }
    
    /**
     * Creation of a deck for each player (shuffle each deck too)
     */
    public void giveDeckToEachPlayer() {
        for(HashMap.Entry<String, Player> linePlayer : players.entrySet()) {
            linePlayer.getValue().giveDeck(new Deck(false));
        }
    }
    
    /**
     * Fill the hands of each player
     */
    public void fillHands() {
        for(HashMap.Entry<String, Player> linePlayer : players.entrySet()) {
            linePlayer.getValue().fillHand();
        }
    }
    
    /**
     * Get the player of the user
     */
    public Player getUser() {
        return players.get("user");
    }
    
    /**
     * Get the player of the IA
     */
    public Player getIA() {
        return players.get("IA");
    }
    
    /**
     * Explicit
     * 
     * Returns :
     *  1 if the user has won
     *  0 if it's a draw
     *  -1 if the IA won
     */
    public int cardBattle(Player user, Player IA) {
        int resultOfBattle = 0;
        Card userCard = user.getActiveCard();
        Card enemyCard = IA.getActiveCard();
        
        GameUI.printBattleMsg(user, IA);
        resultOfBattle = userCard.battle(enemyCard);
        
        return resultOfBattle;
    }
}