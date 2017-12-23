// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)


package upmc.pcg.game;

/**
 * Represent a small deck of reveled card
 *
 * @author Nicolas BOULLET
 */
public class Hand extends Deck {
    public final static int MAX_SIZE = 5;
    
    /**
     * Default constructor
     */
    public Hand() {
        super();
    }
    
    /**
     * Constructor with given owner
     */
    public Hand(String owner) {
        super();
        this.owner = owner;
    }
    
    /**
     * Print the name of the owner and the nb of cards of the deck
     */
    @Override
    public String toString() {
        return "Hand of "+this.owner+"("+nbCards()+")";
    }
    
    /**
     * Add card if the hand is not full
     */
    @Override
    public void addCard(Card card) {
        if(!isFull())
            this.cards.add(0, card);
    }
    
    /**
     * Explicit 
     */
    public boolean isFull() {
        boolean result = false;
        
        if(nbCards() >= MAX_SIZE)
            result = true;
        
        return result;
    }
    
    /**
     * Return the text in the card of the id given
     */
    public String getCardName(int i) {
        return this.cards.get(i).toString();
    }
}