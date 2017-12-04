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
    public final int MAX_SIZE = 5;
    
    public Hand() {
        super();
    }
    
    /**
     * Add card if the hand is not full
     */
    @Override
    public void addCard(Card card) {
        System.out.println("ADD CARD TO HAND"+card.toString());
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
}