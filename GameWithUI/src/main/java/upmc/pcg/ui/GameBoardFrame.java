// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg.ui;

import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import upmc.pcg.game.Game;
import upmc.pcg.game.Player;

/**
 * A class that represent a graphic gameboard with a frame
 *
 * @author Nicolas BOULLET
 */
public class GameBoardFrame extends JFrame {
    
    private GameBoardPanel mainPanel = new GameBoardPanel();
    private Game game;
    
    /**
     * Default constructor
     */
    public GameBoardFrame() {}
    
    /**
     * Initialize the frame and every basic element in it
     */
    public void initialize(HashMap<String, Player> players, Game game) {
        setMainSettings();
        this.game = game;
        setPanelSettings(players);
        
        this.setVisible(true);     
    }
    
    /**
     * Set main settings on the frame
     */ 
    private void setMainSettings() {
        this.setTitle("Elemental Battle");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    /**
     * Set main panel settings
     */
    private void setPanelSettings(HashMap<String, Player> players) {
        this.mainPanel.construct(players, this, game);
        this.setContentPane(mainPanel);
    }

    public void printResultOfBattle(Player user, Player IA, int resultOfBattle) {
        switch(resultOfBattle) {
            case 1:
                JOptionPane.showMessageDialog(null, user.printName()+" has won this battle!");
                break;
            case -1:
                JOptionPane.showMessageDialog(null, IA.printName()+" has won this battle!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "It's a draw !");
                break;
        }
    }
    
    /**
     * Revalidate every element on the panel
     */
    public void revalidatePanel() {
        mainPanel.revalidateAll();
    }
}