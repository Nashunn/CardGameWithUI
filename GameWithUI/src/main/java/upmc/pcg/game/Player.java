// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.game;

/**
 * Represent a player
 *
 * @author Nicolas BOULLET
 */
public class Player {
    private String name = "Default";
    private Deck deck;
    private Hand hand;
    private int score = 0;
    private boolean isIA = false;
    private boolean hasWon = false;
    private boolean hasGiveUp = false;
    
    /**
     * Default constructor
     */
    public Player() {}
    
    /**
     * Constructor with name
     */
    public Player(String name) {
        this.name = name;
    }
    
    /**
     * Constructor with boolean to decide if the player is an IA
     */
    public Player(boolean isIA) {
        if(isIA) {
            this.name = "IA";
            this.isIA = isIA;
        }
    }
    
    
    /**
     * Explicit
     */    
    @Override
    public String toString() {
        return this.name+"("+this.score+" point"+(this.score>1?"s":"")+")";
    }
    
    /**
     * Give a specific deck to a player
     */
    public void giveDeck(Deck newDeck) {
        this.deck = newDeck;
    }
}