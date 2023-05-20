package GUI;

import Game.Game;
import Game.HostGameMode;
import Game.Variables;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author eby
 */
public class TableListenerOnMapCreator implements ActionListener {

    final int Apple = 5;
    final int Star = 10;
    final int Mushroom = -5;
    final int wall = -10;
    final int FirstPlayer = 1;
    final int SecendPlayer = 2;
    private int i;
    private int j;
    public String icon;
    public boolean putPlayer1 = false;
    public boolean putPlayer2 = false;
    public Game game;

    TableListenerOnMapCreator(Game game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String location[] = event.toString().substring(event.toString().indexOf(" on ") + 4).split(" ");
        JButton btn = (JButton) event.getSource();
        i = Integer.parseInt(location[0]);
        j = Integer.parseInt(location[1]);

        if (icon != null) {
            switch (icon) {
                case "star":
                    if (game.board.board[i][j] == FirstPlayer) {
                        putPlayer1 = false;

                    } else if (game.board.board[i][j] == SecendPlayer) {
                        putPlayer2 = false;
                    }
                    game.board.board[i][j] = Star;
                    btn.setIcon(new ImageIcon(new ImageIcon("Image/star.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                    break;
                case "apple":
                    if (game.board.board[i][j] == FirstPlayer) {
                        putPlayer1 = false;
                    } else if (game.board.board[i][j] == SecendPlayer) {
                        putPlayer2 = false;
                    }
                    game.board.board[i][j] = Apple;
                    btn.setIcon(new ImageIcon(new ImageIcon("Image/apple.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                    break;
                case "mushRoom":
                    if (game.board.board[i][j] == FirstPlayer) {
                        putPlayer1 = false;
                    } else if (game.board.board[i][j] == SecendPlayer) {
                        putPlayer2 = false;
                    }
                    game.board.board[i][j] = Mushroom;
                    btn.setIcon(new ImageIcon(new ImageIcon("Image/mushRoom.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                    break;
                case "wall":
                    if (game.board.board[i][j] == FirstPlayer) {
                        putPlayer1 = false;
                    } else if (game.board.board[i][j] == SecendPlayer) {
                        putPlayer2 = false;
                    }
                    game.board.board[i][j] = wall;
                    btn.setIcon(new ImageIcon(new ImageIcon("Image/wall.jfif").getImage().getScaledInstance(Variables.squerLine + 15, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                    break;
                case "firstPlayer":
                    if (!putPlayer1) {
                        if (game.board.board[i][j] == 2) {
                            putPlayer2 = false;
                        }
                        putPlayer1 = true;
                        game.board.board[i][j] = FirstPlayer;
                        btn.setIcon(new ImageIcon(new ImageIcon("Image/player1.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                    }
                    break;
                case "secendPlayer":
                    if (!putPlayer2) {
                        if (game.board.board[i][j] == 1) {
                            putPlayer1 = false;
                        }
                        putPlayer2 = true;
                        game.board.board[i][j] = SecendPlayer;
                        btn.setIcon(new ImageIcon(new ImageIcon("Image/player2.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                    }
                    break;
                case "remove":
                    if (game.board.board[i][j] == 1) {
                        putPlayer1 = false;

                    }
                    if (game.board.board[i][j] == 2) {
                        putPlayer2 = false;
                    }
                    game.board.board[i][j] = 0;
                    btn.setIcon(null);
                    break;
            }
        }
        if (game instanceof HostGameMode) {
            try {
                Variables.server.getOutputStream().writeUTF(i + " " + j + " " + icon);
            } catch (IOException ex) {
                Variables.client.closeClient();
                Variables.server.closeServer();
                JOptionPane.showMessageDialog(null, "Connection Feild");
                MenuGame menu = game.getMenu();
                menu = new MenuGame();
                game.getGui().getMainMap().frame.dispose();
            }
        }

        if (putPlayer1 && putPlayer2 && game.board.starCounter() > 0) {
            game.getGui().getMapCreator().getStartBtn().setVisible(true);
        } else {
            game.getGui().getMapCreator().getStartBtn().setVisible(false);
        }
    }
}
