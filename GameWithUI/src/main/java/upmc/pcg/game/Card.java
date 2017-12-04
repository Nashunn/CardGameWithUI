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
    public static String ELEMENTS[] = {"fire", "water", "plant", "air"};
    
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
}