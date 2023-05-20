package Game;

import GUI.GUI;
import GUI.MenuGame;
import javax.swing.JOptionPane;

/**
 *
 * @author eby
 */
public class Game {

    protected final GUI gui;
    public GameBoard board = new GameBoard();
    protected final Player[] player;
    protected Move move;
    private MenuGame menu;

    public Game() {
        this.player = new Player[2];
        gui = new GUI(this);
    }

    public void startGame() {
        createPlayers();
        gui.drawMainMap();
        if (gui.getMapCreator().game instanceof HostGameMode) {
            gui.getMainMap().getHostLoop().setPlayers(player);
        } else if (gui.getMapCreator().game instanceof JoinGameMode) {
            gui.getMainMap().getJoinLoop().setPlayers(player);
            ThearedForReceiveDataFramServer firstRequestOfClient = new ThearedForReceiveDataFramServer(gui.getMainMap().getJoinLoop());
            firstRequestOfClient.start();
        } else {
            gui.getMainMap().tableListenerOnMainMap.setPlayers(player);
        }
    }

    protected void createPlayers() {
        move = new Move(board);
        for (int i = 0; i < 2; i++) {
            player[i] = new Player(move);
            player[i].setName("Player " + (i + 1));
            player[i].setName(JOptionPane.showInputDialog("Please Enter name Of player " + (i + 1) + " (less than 12 Charactor)"));
        }
        findPrimeLocationOfPlayer();
    }

    protected void findPrimeLocationOfPlayer() {
        for (int i = 0; i < Variables.getRow(); i++) {
            for (int j = 0; j < Variables.getCool(); j++) {
                if (board.board[i][j] == 1) {
                    player[0].setNowX(i);
                    player[0].setNowY(j);
                } else if (board.board[i][j] == 2) {
                    player[1].setNowX(i);
                    player[1].setNowY(j);
                }
            }
        }
    }

    public GUI getGui() {
        return gui;
    }

    public MenuGame getMenu() {
        return menu;
    }

    public void setMenu(MenuGame menu) {
        this.menu = menu;
    }
    
}
