// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import upmc.pcg.game.Game;
import upmc.pcg.game.Player;

/**
 * A class that represent a graphic gameboard with a frame
 *
 * @author Nicolas BOULLET
 */
public class UserPanel extends JPanel {
    private GameBoardFrame parentFrame = null;
    private ArrayList<CardButton> buttons = new ArrayList<>();
    private Player user = new Player();
    private Game game = null;
    
    /**
     * Default constructor
     */
    public UserPanel(){}
    
    /**
     * Explicit
     */
    public void construct() {
        setButtonsListener();
        for(CardButton button : this.buttons) {
            this.add(button);
            if(this.user.printName().equals("IA"))
                button.setEnabled(false);
        }
    }
    
    /**
     * Initialize the game with the current game object
     */
    public void initGame(Game game) {
        this.game = game;
    }
    
    /**
     * Explicit
     */
    public void setFrame(GameBoardFrame frame) {
        this.parentFrame = frame;
    }
    
    /**
     * Explicit
     */
    public void setButtonsList(ArrayList<CardButton> buttons) {
        this.buttons = buttons;
    }
    
    /**
     * Explicit
     */
    public void setUser(Player user) {
        this.user = user;
    }
    
    /**
     * Explicit
     */
    public void enableButtons(boolean enable) {
        for(CardButton button : this.buttons) {
            if(enable)
                button.setEnabled(true);
            else
                button.setEnabled(false);
        }
    }
    
    /**
     * Set the CardSelectListener on buttons
     */
    public void setButtonsListener() {    
        for(int i=0; i<this.buttons.size(); i++) {
            buttons.get(i).addActionListener(setCardSelectListener(i, this, this.parentFrame, this.game));
        }
    }
    
    /**
     * The user set a card as an active card
     */
    public void userSelectCard(int cardNb) {
        this.user.playCard(cardNb);
    }
    
    /**
     * Set a Listener for a button
     */
    public ActionListener setCardSelectListener(int cardNb, UserPanel panel, GameBoardFrame frame, Game game) { 
        
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //panel.enableButtons(false);
                panel.userSelectCard(cardNb);
                
                if(frame != null) {
                    frame.revalidatePanel();
                }
                game.launchBattle();
            }
        };
        
        return al;
    }
}