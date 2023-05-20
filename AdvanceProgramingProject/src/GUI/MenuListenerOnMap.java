package GUI;

import Game.HostGameMode;
import Game.JoinGameMode;
import Game.Variables;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author eby
 */
public class MenuListenerOnMap implements ActionListener {

    MainMap thisMap;
    MapCreator mapCreator;

    public MenuListenerOnMap(MainMap thisMap) {
        this.thisMap = thisMap;
    }

    public MenuListenerOnMap(MapCreator mapCreator) {
        this.mapCreator = mapCreator;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (thisMap != null) {
            MenuGame menu = this.thisMap.map.game.getMenu();
            if (thisMap.map.game instanceof HostGameMode) {
                Variables.server.closeServer();
                JOptionPane.showMessageDialog(null, "Connection Feild");
            } else if (thisMap.map.game instanceof JoinGameMode) {
                Variables.client.closeClient();
                JOptionPane.showMessageDialog(null, "Connection Feild");

            }
            thisMap.frame.dispose();
            Variables.setRowAndCool(10, 10);
            menu = new MenuGame();

        } else {
            ArrayList<String> a = new ArrayList<>();
            ArrayList<String> b = new ArrayList<>();
             MenuGame menu = this.mapCreator.game.getMenu();
            if (mapCreator.game instanceof HostGameMode) {
                Variables.server.closeServer();
                JOptionPane.showMessageDialog(null, "Connection Feild");
            } else if (mapCreator.game instanceof JoinGameMode) {
                Variables.client.closeClient();
                JOptionPane.showMessageDialog(null, "Connection Feild");

            }
            mapCreator.getFrame().dispose();
            Variables.setRowAndCool(10, 10);
            menu = new MenuGame();
        }

    }

}
