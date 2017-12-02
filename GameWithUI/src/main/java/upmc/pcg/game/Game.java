// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.game;

import java.util.ArrayList;
import java.util.HashMap;
import upmc.pcg.ui.GameUI;
/**
 * Class that contains methods to run the game
 *
 * @author Nicolas BOULLET
 */
public class Game {
    private HashMap<String, Deck> decks = new HashMap<String, Deck>();
    private HashMap<String, Player> players;
    private CardBoard cardboard;
    private boolean boolQuitGame = false;
    
    /**
     * Explicit
     */
    public void initialize() {
        players = GameUI.createPlayers();
        
        //Creation of a deck for each player (shuffle each deck too)
        for(HashMap.Entry<String, Player> player : players.entrySet()) {
            
        }
        
        //Place each player on the cardBoard
    }
    
    /**
     * Explicit
     */
    public void play() {
        
    }
}