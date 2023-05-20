package GUI;

import Game.HostGameMode;
import Game.MyServer;
import Game.Variables;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author eby
 */
public class NewHost implements ActionListener {

    private MyServer server;
    private final MenuGame menu;

    public NewHost(MenuGame menu) {
        this.menu = menu;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        server = new MyServer(4800);
        Variables.server=server;
        HostGameMode hostHostGame = new HostGameMode();
        hostHostGame.setMenu(menu);
        menu.getFrame().dispose();
        
         
    }

}
