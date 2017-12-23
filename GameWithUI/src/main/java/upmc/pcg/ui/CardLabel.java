// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.ui;

import javax.swing.JLabel;
import upmc.pcg.game.Card;


/**
 * A class that represent a card during battle
 *
 * @author Nicolas BOULLET
 */
public class CardLabel extends JLabel {

    CardLabel(Card activeCard) {
        if(activeCard != null)
            this.setText(activeCard.toString());
        else
            this.setText("No card on board");
    }
    
}