// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.game;

import java.util.ArrayList;
import java.util.HashMap;
import upmc.pcg.ui.CardBoardUI;

/**
 * Class that contains methods to run the game
 *
 * @author Nicolas BOULLET
 */
public class Game {
    private HashMap<String, Deck> decks = new HashMap<String, Deck>();
    private ArrayList<Player> players;
    private CardBoard cardboard;
    private boolean boolQuitGame = false;
    
    public void initialize() {
        //Creation of a player with his name
        //Creation of a deck for each player (shuffle each deck too)
        //Place each player on the cardBoard
    }
}