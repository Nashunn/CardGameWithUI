// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import upmc.pcg.game.Player;

/**
 * A class that represent a graphic gameboard with a frame
 *
 * @author Nicolas BOULLET
 */
public class GameBoardPanel extends JPanel {
    private JFrame parentFrame = null;
    private final GridLayout mainLayout = new GridLayout(3,1);
    private final UserPanel enemyPanel = new UserPanel();
    private final JPanel battlePanel = new JPanel(new GridLayout(2,1));
    private final UserPanel userPanel = new UserPanel();
    private Player enemy;
    private Player user;
    
    /**
     * Default Constructor
     */
    public GameBoardPanel() {}
    
    /**
     * Explicit
     */
    public void construct(HashMap<String, Player> players, JFrame parent) {
        cleanAll();
        
        this.parentFrame = parent;
        this.setLayout(mainLayout);
        setPlayers(players);
        
        constructAllPanels();
        setAllPanels();
        
        setVisible(true);
    }
    
    /**
     * Explicit
     */
    private void setPlayers(HashMap<String, Player> players) {
        this.enemy = players.get("IA");
        this.user = players.get("user");
    }
    
    /**
     * Clean every component in the Jpanel
     */
    private void cleanAll() {
        this.removeAll();
    }
    
    /**
     * Explicit
     */
    private void constructAllPanels() {
        constructPlayerPanel(enemyPanel, enemy, null);
        constructPlayerPanel(userPanel, user, this.parentFrame);
        constructBattlePanel();
    }
    
    /**
     * Set all the panels on the current panel
     */
    private void setAllPanels() {
        this.add(enemyPanel);
        this.add(battlePanel);
        this.add(userPanel);
    }
    
    /**
     * Place all the CardButtons made from the hand of the player given
     */
    private void constructPlayerPanel(UserPanel panel, Player player, JFrame parentFrame) {
        panel.setUser(player);
        panel.setButtonsList(createButtonsList(player));
        panel.setFrame(parentFrame);
    }
    
    /**
     * Place labels of battle cards
     */
    private void constructBattlePanel() {
        if(user.getActiveCard()!=null && enemy.getActiveCard()!=null) {
            battlePanel.add(new CardLabel(enemy.getActiveCard()));
            battlePanel.add(new CardLabel(user.getActiveCard()));
        }
    }
    
    /**
     * Return an arrayList of CardButtons
     */
    private ArrayList<CardButton> createButtonsList(Player player) {
        ArrayList<CardButton> result = new ArrayList<>();
        
        for(int i=0; i<player.nbCardHand(); i++) {
            CardButton cb;
            
            if(player.equals(user))
                cb = new CardButton(i, player.getCardNameInHand(i));
            else
                cb = new CardButton(i, "IA card");
            
            result.add(cb);
        }
        
        return result;
    }
}
    