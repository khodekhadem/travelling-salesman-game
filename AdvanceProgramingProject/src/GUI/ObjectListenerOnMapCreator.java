package GUI;

import Game.HostGameMode;
import Game.Variables;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eby
 */
public class ObjectListenerOnMapCreator implements ActionListener {

    private final TableListenerOnMapCreator tableListenerOnMapCreator;

    public ObjectListenerOnMapCreator(TableListenerOnMapCreator tableListenerOnMapCreator) {
        this.tableListenerOnMapCreator = tableListenerOnMapCreator;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton btn = (JButton) event.getSource();
        switch (btn.getName()) {
            case "star":
                tableListenerOnMapCreator.icon = "star";
                break;
            case "apple":
                tableListenerOnMapCreator.icon = "apple";
                break;
            case "mushRoom":
                tableListenerOnMapCreator.icon = "mushRoom";
                break;
            case "wall":
                tableListenerOnMapCreator.icon = "wall";
                break;
            case "firstPlayer":
                tableListenerOnMapCreator.icon = "firstPlayer";
                break;
            case "secendPlayer":
                tableListenerOnMapCreator.icon = "secendPlayer";
                break;
            case "remove":
                tableListenerOnMapCreator.icon = "remove";
                break;
            case "start":
                if (tableListenerOnMapCreator.putPlayer1 && tableListenerOnMapCreator.putPlayer2 && tableListenerOnMapCreator.game.board.starCounter() > 0) {
                    tableListenerOnMapCreator.game.startGame();
                    if (tableListenerOnMapCreator.game instanceof HostGameMode) {
                        try {
                            Variables.server.getOutputStream().writeUTF(-1 + " " + -1 + " " + "start");
                        } catch (IOException ex) {
                            Variables.client.closeClient();
                            Variables.server.closeServer();
                            JOptionPane.showMessageDialog(null, "Connection Feild");
                            MenuGame menu = tableListenerOnMapCreator.game.getMenu();
                            menu = new MenuGame();
                            tableListenerOnMapCreator.game.getGui().getMainMap().frame.dispose();
                        }
                    }
                }
                break;
            case "RESIZE":
                boolean isChange = true;
                try {
                    int row = Integer.parseInt(JOptionPane.showInputDialog("please Enter number of row for game table (50>row>2)"));
                    int cool = Integer.parseInt(JOptionPane.showInputDialog("please Enter number of cool for game table (50>cool>2)"));
                    if (row == Variables.getRow() && cool == Variables.getCool()) {
                        isChange = false;
                    } else {
                        Variables.setRow(row);
                        Variables.setCool(cool);
                    }
                } catch (HeadlessException | NumberFormatException e) {
                    isChange = false;
                }
                if (isChange) {
                    JFrame oldFrame = tableListenerOnMapCreator.game.getGui().getMapCreator().getFrame();
                    tableListenerOnMapCreator.game.getGui().newMapCreator();
                    oldFrame.dispose();
                    if (tableListenerOnMapCreator.game instanceof HostGameMode) {
                        try {
                            Variables.server.getOutputStream().writeUTF(Variables.getRow() + " " + Variables.getCool() + " " + "RESIZE");
                        } catch (IOException ex) {
                            Variables.client.closeClient();
                            Variables.server.closeServer();
                            JOptionPane.showMessageDialog(null, "Connection Feild");
                            MenuGame menu = tableListenerOnMapCreator.game.getMenu();
                            menu = new MenuGame();
                            tableListenerOnMapCreator.game.getGui().getMainMap().frame.dispose();
                        }
                    }
                }
                break;
            case "newMap":
                JFrame oldFrame = tableListenerOnMapCreator.game.getGui().getMapCreator().getFrame();
                tableListenerOnMapCreator.game.getGui().newMapCreator();
                oldFrame.dispose();
                if (tableListenerOnMapCreator.game instanceof HostGameMode) {
                    try {
                        Variables.server.getOutputStream().writeUTF(Variables.getRow() + " " + Variables.getCool() + " " + "newMap");
                    } catch (IOException ex) {
                        Variables.client.closeClient();
                        Variables.server.closeServer();
                        JOptionPane.showMessageDialog(null, "Connection Feild");
                        MenuGame menu = tableListenerOnMapCreator.game.getMenu();
                        menu = new MenuGame();
                        tableListenerOnMapCreator.game.getGui().getMainMap().frame.dispose();
                    }
                }
                break;
        }
    }
}
