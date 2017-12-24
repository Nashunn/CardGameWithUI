// School project : CardGame with an UI
//
// Written by Nicolas BOULLET
// Studying at UPMC in Licence Pro Projet Web (2017/2018)

package upmc.pcg;

import upmc.pcg.game.Game;
import upmc.pcg.ui.MenuUI;

/**
 * Main Class of the game
 * 
 * @author Nicolas BOULLET
 */
public class ElementalBattle {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        boolean launch = false;
        
        launch = MenuUI.launcherMenu();
        
        if(launch) {
            game.initialize();
            game.play();
        }
        else
            MenuUI.printQuitGame();
    }   
}