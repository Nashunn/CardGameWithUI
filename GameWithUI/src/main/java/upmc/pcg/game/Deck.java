// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.game;

import java.util.ArrayList;
import java.util.Collections;
import upmc.pcg.ui.GameUI;

/**
 * Represente a deck of cards
 *
 * @author Nicolas BOULLET
 */
public class Deck {
    protected String owner = "DefaultOwner";
    protected ArrayList<Card> cards = new ArrayList<>();
    
    /**
     * Default constructor
     */
    public Deck() {}
    
    /**
     * Constructor with a boolean isEmpty
     */
    public Deck(boolean isEmpty) {
        if(!isEmpty) {
            for(int iElt=0; iElt<Card.ELEMENTS.length; iElt++) {
                for(int iNb=1; iNb<=5; iNb++) {
                    cards.add(new Card(iNb, Card.ELEMENTS[iElt]));
                }
            }
            //Add the last 5 random cards
            for(int iNb=1; iNb<=5; iNb++) {
                cards.add(new Card(iNb, Card.ELEMENTS[GameUI.generateRandomInt(0, 3)]));
            }
            
            this.shuffle();
        }
    }
    
    /**
     * Print the name of the owner and the nb of cards of the deck
     */
    @Override
    public String toString() {
        return "Deck of "+this.owner+" ("+nbCards()+")";
    }
    
    /**
     * Print all cards in the form of a list
     */
    public String listCards() {
        String list = "";
        if(!this.isEmpty()) {
            for(int i=0; i<nbCards(); i++) {
                list += (i+1)+". "+this.cards.get(i).toString()+"\n";
            }
        }
        else {
            list += "(!) No cards\n";
        }

        return list;
    }
    
    /**
     * Set an owner
     */
    public void setOwner(String newOwner) {
        this.owner = newOwner;
    }
    
    /**
     * Return the nb of cards in the deck
     * @return 
     */
    public int nbCards() {
        return this.cards.size();
    }
    
    /**
     * Explicit 
     */
    public boolean isEmpty() {
        if(nbCards() == 0) 
            return true;
        else
            return false;
    }
    
    /**
     * Explicit
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }
    
    /**
     * Explicit
     */
    public Card pickCard(int i) {
        Card result = null;
        
        if(!isEmpty() && (i>=0 && i<cards.size()))
            result = this.cards.remove(i);
        
        return result;
    }
    
    /**
     * Explicit 
     */
    public Card pickLastCard() {
        return pickCard(nbCards()-1);
    }
    
    /**
     * Add a card at the beginning of the deck
     */
    public void addCard(Card card) {
        this.cards.add(0, card);
    }
}