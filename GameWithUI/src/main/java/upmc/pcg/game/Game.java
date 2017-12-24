// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.game;

import java.util.HashMap;
import upmc.pcg.ui.GameBoardFrame;
import upmc.pcg.ui.GameUI;
import upmc.pcg.ui.MenuUI;

/**
 * Class that contains methods to run the game
 *
 * @author Nicolas BOULLET
 */
public class Game {
    private HashMap<String, Player> players;
    private boolean boolQuitGame = false;
    private static boolean battleReady = false;
    private int resultBattle = 0;
    private GameBoardFrame gameboard = new GameBoardFrame();
    
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
    public void play() throws InterruptedException {        
        do {
            fillHands();
            
            gameboard.initialize(players, this);
            //GameUI.askCard(getUser(), getIA());

            while(!battleReady) { Thread.sleep(200); } //Wait the user to chose a card
            
            selectCardForIA();
            resultBattle = cardBattle(getUser(), getIA());
            givePointToPlayer();
            boolQuitGame = MenuUI.endOfTurn(getUser(), getIA());
            battleReady = false;
        } while(!boolQuitGame && !(getUser().getGiveUp() || getIA().getGiveUp()));
        
        GameUI.printEndGame(getUser(), getIA());
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
    private Player getUser() {
        return players.get("user");
    }
    
    /**
     * Get the player of the IA
     */
    private Player getIA() {
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
        
        resultOfBattle = userCard.battle(enemyCard);
        
        gameboard.printResultOfBattle(user, IA, resultOfBattle);
        
        GameUI.printResultOfBattle(user, IA, resultOfBattle);
        
        return resultOfBattle;
    }
    
    /**
     * Give point to a player based on the result of the battle
     */
    public void givePointToPlayer() {
        switch(resultBattle) {
            case 1:
                getUser().winPoint();
                break;
            case -1:
                getIA().winPoint();
                break;
            default:
                break;
        }
    }
    
    /**
     * Select a card for the IA before the battle
     */
    public void selectCardForIA() {
        getIA().playCard(GameUI.generateRandomInt(0, getIA().nbCardHand()-1)); 
    }
    
    /**
     * Tell the UI it can launch the battle by putting boolean battleReady at true
     */
    public void launchBattle() {
        this.battleReady = true;
    }
    
    /**
     * Telle the UI it's the end of the battle by putting boolean battleReady at false
     */
    public void endBattle() {
        this.battleReady = false;
    }
}