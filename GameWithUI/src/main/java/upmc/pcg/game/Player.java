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
        this.hand = new Hand(name);
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
    
    public String printName() {
        return this.name;
    }
    
    /**
     * Give a specific deck to a player
     */
    public void giveDeck(Deck newDeck) {
        this.deck = newDeck;
        this.deck.setOwner(this.name);
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
        while(!this.hand.isFull() && !this.deck.isEmpty()) {
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
     * Get a card in hand by its number
     */
    public String getCardNameInHand(int iCard) {
        return this.hand.getCardName(iCard);
    }
    
    /**
     * Explicit
     */
    public int nbCardHand() {
        return this.hand.nbCards();
    }
    
    /**
     * Play a card by putting it as the active card of the player
     */
    public void playCard(Card activeCard) {
        this.activeCard = activeCard;
    }
    
    /**
     * Play a card by putting it as the active card of the player 
     * take the id of the card
     */
    public void playCard(int activeCardID) {
        this.activeCard = this.hand.pickCard(activeCardID);
    }
    
    /**
     * Return the active card of the player
     */
    public Card getActiveCard() {
        return this.activeCard;
    }
    
    /**
     * Explicit
     */
    public boolean isHandEmpty() {
        return this.hand.isEmpty();
    }
    
    /**
     * Add one point to the score
     */
    public void winPoint() {
        this.score++;
    }
    
    /**
     * Return the score
     */
    public int getScore() {
        return this.score;
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