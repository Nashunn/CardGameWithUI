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
    private Deck deck = new Deck(true);
    private Hand hand = new Hand();
    private Card activeCard = null;
    private int score = 0;
    private boolean isIA = false;
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
    
    /**
     * Explicit
     */
    public boolean isDeckEmpty() {
        return this.deck.isEmpty();
    }
    
    /**
     * Explicit
     */
    public void addCardToDeck(Card newCard) {
        this.deck.addCard(newCard);
    }
    
    /**
     * Explicit
     */
    public void addCardToHand(Card newCard) {
        this.hand.addCard(newCard);
    }
    
    /**
     * Fill hand with card from the deck
     */
    public void fillHand() {
        System.out.println("REMPLIS LA MAIN");
        while(!this.hand.isFull()) {
            addCardToHand(this.deck.pickLastCard());
        }
    }
    
    /**
     * Explicit
     */
    public String listDeck() {
        return this.deck.listCards();
    }
    
    /**
     * Explicit
     */
    public String listHand() {
        return this.hand.listCards();
    }
    
    /**
     * Play a card by putting it as the active card of the player
     */
    public void playCard(Card activeCard) {
        this.activeCard = activeCard;
    }
    
    /**
     * Explicit
     */
    public boolean isHandEmpty() {
        return this.hand.isEmpty();
    }
    
    /**
     * Explicit
     */
    public void giveUp() {
        this.hasGiveUp = true;
    }
    
    /**
     * Return hasGiveUp
     */
    public boolean getGiveUp() {
        return this.hasGiveUp;
    }
    
    /**
     * Return isIA
     */
    public boolean getIsIA() {
        return this.isIA;
    }    
}