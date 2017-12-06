// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)


package upmc.pcg.game;

import java.util.Random;
import upmc.pcg.ui.GameUI;

/**
 * Represent a card of the game
 *
 * @author Nicolas BOULLET
 */
public class Card {
    private int damage;
    private String element;
    public static final String ELEMENTS[] = {"water", "fire", "plant", "air"};
    
    /**
     * Default constructor
     * construct a card between 1 and 5 dmg, with a random element
     */
    public Card() {
        this.damage = GameUI.generateRandomInt(1, 5);
        this.element = ELEMENTS[GameUI.generateRandomInt(0, 3)];
    }
    
    /**
     * Constructor with damage and element
     */
    public Card(int dmg, String elt) {
        this.damage = dmg;
        this.element = elt;
    }
    
    /**
     * Print the card in the form : 'damage' of 'element'
     */
    public String toString() {
        return this.damage+" of "+this.element;
    }
    
    /**
     * Explicit
     * 
     * Returns :
     *  1 if the user has won
     *  0 if it's a draw
     *  -1 if the IA won
     */
    public int battle(Card enemyCard) {
        int result = 0;
        int cardDmg = this.damage;
        int enemyDmg = enemyCard.damage;
        
        switch(switchAddBonusDmg(this.element, enemyCard.element)) {
            case 1:
                cardDmg++;
                break;
            case -1:
                enemyDmg++;
                break;
        }        
        
        result = compareDmg(cardDmg, enemyDmg);
        
        return result;
    }
    
    /**
     * Decide which card in the battle is going
     * to have a dmg bonus
     * 
     * Returns :
     *  1 if the current card got the bonus
     *  0 if none of the cards got the bonus
     *  -1 if the enemy card got the bonus
     */
    private int switchAddBonusDmg(String cardElt, String enemyElt) {
        int result = 0;
        
        if(cardElt.equals(ELEMENTS[0])) {
            if(enemyElt.equals(ELEMENTS[1]))
                result = 1;
            else if(enemyElt.equals(ELEMENTS[3]))
                result = -1;
        }
        else if(cardElt.equals(ELEMENTS[1])) {
            if(enemyElt.equals(ELEMENTS[2]))
                result = 1;
            else if(enemyElt.equals(ELEMENTS[0]))
                result = -1;
        }
        else if(cardElt.equals(ELEMENTS[2])) {
            if(enemyElt.equals(ELEMENTS[3]))
                result = 1;
            else if(enemyElt.equals(ELEMENTS[1]))
                result = -1;
        }
        else if(cardElt.equals(ELEMENTS[3])) {
            if(enemyElt.equals(ELEMENTS[0]))
                result = 1;
            else if(enemyElt.equals(ELEMENTS[2]))
                result = -1;
        }
        
        return result;
    }
    
    /**
     * Explicit
     * 
     * Returns :
     *  1 if the user has won
     *  0 if it's a draw
     *  -1 if the IA won 
     */
    private int compareDmg(int cardDmg, int enemyDmg) {
        int result = 0;
        
        if(cardDmg>enemyDmg)
            result = 1;
        else if(cardDmg<enemyDmg)
            result = -1;
        
        return result;
    }
}