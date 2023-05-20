package GUI;

import Game.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author eby
 */
public class NewTwoPlayerGame implements ActionListener{
     private final MenuGame menu;

    public NewTwoPlayerGame(MenuGame menu) {
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Game game = new Game();
        game.setMenu(menu);
        menu.getFrame().dispose();
    }
    
     
}
