package GUI;

import Game.JoinGameMode;
import Game.MyClient;
import Game.Variables;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author eby
 */
public class NewJoin implements ActionListener {

    MyClient client;
    
    private final MenuGame menu;

    public NewJoin(MenuGame menu) {
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        client = new MyClient("127.0.0.1", 4800);
        Variables.client = client;
        JoinGameMode joinGame = new JoinGameMode();
        joinGame.setMenu(menu);
        menu.getFrame().dispose();
    }
}
