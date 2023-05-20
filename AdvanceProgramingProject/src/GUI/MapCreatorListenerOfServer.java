package GUI;

import Game.JoinGameMode;
import Game.Variables;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eby
 */
public class MapCreatorListenerOfServer {

    String icon = "";
    JoinGameMode joinGame;
    final int Apple = 5;
    final int Star = 10;
    final int Mushroom = -5;
    final int wall = -10;
    final int FirstPlayer = 1;
    final int SecendPlayer = 2;
    public boolean putPlayer1 = false;
    public boolean putPlayer2 = false;
    private int i;
    private int j;

    public MapCreatorListenerOfServer(JoinGameMode joinGame) {
        this.joinGame = joinGame;
    }

    public void putObjectOnClientMap() {

        while (true) {

            try {
                String[] ServerDataBox;
                ServerDataBox = Variables.client.getInputStream().readUTF().split(" ");
                i = Integer.parseInt(ServerDataBox[0]);
                j = Integer.parseInt(ServerDataBox[1]);
                icon = ServerDataBox[2];
            } catch (IOException ex) {
                Variables.client.closeClient();
                Variables.server.closeServer();
                JOptionPane.showMessageDialog(null, "Connection Feild");
                MenuGame menu =joinGame.getMenu();
                menu=new MenuGame();
                joinGame.getGui().getMainMap().frame.dispose();
            }
            if (icon != null) {
                switch (icon) {
                    case "star":
                        if (joinGame.board.board[i][j] == FirstPlayer) {
                            putPlayer1 = false;

                        } else if (joinGame.board.board[i][j] == SecendPlayer) {
                            putPlayer2 = false;
                        }
                        joinGame.board.board[i][j] = Star;
                        joinGame.board.btnBoard[i][j].setIcon(new ImageIcon(new ImageIcon("Image/star.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                        break;
                    case "apple":
                        if (joinGame.board.board[i][j] == FirstPlayer) {
                            putPlayer1 = false;
                        } else if (joinGame.board.board[i][j] == SecendPlayer) {
                            putPlayer2 = false;
                        }
                        joinGame.board.board[i][j] = Apple;
                        joinGame.board.btnBoard[i][j].setIcon(new ImageIcon(new ImageIcon("Image/apple.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                        break;
                    case "mushRoom":
                        if (joinGame.board.board[i][j] == FirstPlayer) {
                            putPlayer1 = false;
                        } else if (joinGame.board.board[i][j] == SecendPlayer) {
                            putPlayer2 = false;
                        }
                        joinGame.board.board[i][j] = Mushroom;
                        joinGame.board.btnBoard[i][j].setIcon(new ImageIcon(new ImageIcon("Image/mushRoom.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                        break;
                    case "wall":
                        if (joinGame.board.board[i][j] == FirstPlayer) {
                            putPlayer1 = false;
                        } else if (joinGame.board.board[i][j] == SecendPlayer) {
                            putPlayer2 = false;
                        }
                        joinGame.board.board[i][j] = wall;
                        joinGame.board.btnBoard[i][j].setIcon(new ImageIcon(new ImageIcon("Image/wall.jfif").getImage().getScaledInstance(Variables.squerLine + 15, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                        break;
                    case "firstPlayer":
                        if (!putPlayer1) {
                            if (joinGame.board.board[i][j] == 2) {
                                putPlayer2 = false;
                            }
                            putPlayer1 = true;
                            joinGame.board.board[i][j] = FirstPlayer;
                            joinGame.board.btnBoard[i][j].setIcon(new ImageIcon(new ImageIcon("Image/player1.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                        }
                        break;
                    case "secendPlayer":
                        if (!putPlayer2) {
                            if (joinGame.board.board[i][j] == 1) {
                                putPlayer1 = false;
                            }
                            putPlayer2 = true;
                            joinGame.board.board[i][j] = SecendPlayer;
                            joinGame.board.btnBoard[i][j].setIcon(new ImageIcon(new ImageIcon("Image/player2.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                        }
                        break;
                    case "remove":
                        if (joinGame.board.board[i][j] == 1) {
                            putPlayer1 = false;
                        }
                        if (joinGame.board.board[i][j] == 2) {
                            putPlayer2 = false;
                        }
                        joinGame.board.board[i][j] = 0;
                        joinGame.board.btnBoard[i][j].setIcon(null);
                        break;
                    case "start":
                        if (putPlayer1 && putPlayer2 && joinGame.board.starCounter() > 0) {
                            joinGame.startGame();
                        }
                        return;
                    case "RESIZE":
                        Variables.setRow(i);
                        Variables.setCool(j);
                        JFrame oldFrame = joinGame.getGui().getMapCreator().getFrame();
                        joinGame.getGui().newMapCreator();
                        oldFrame.dispose();
                        return;
                    case "newMap":
                        oldFrame = joinGame.getGui().getMapCreator().getFrame();
                        joinGame.getGui().newMapCreator();
                        oldFrame.dispose();
                        return;
                }
            }
        }
    }
 
}
