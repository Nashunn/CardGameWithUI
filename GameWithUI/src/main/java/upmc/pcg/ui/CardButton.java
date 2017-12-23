// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.ui;

import javax.swing.JButton;

/**
 * A class that represent a clickable card
 *
 * @author Nicolas BOULLET
 */
public class CardButton extends JButton {
    private int id = 0;
    private String cardName = "No card";
    
    /**
     * Default constructor
     */
    public CardButton(){
        this.setText(cardName);
    }
    
    /**
     * Constructor with the id and the card
     */
    public CardButton(int i, String name) {
        this.id = i;
        this.cardName = name;
        
        this.setText(cardName);
    }
    
    /**
     * Return the id of the button
     */
    public int getId() {
        return this.id;
    }
}