package Game;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author eby
 */
public class Move {

    final int Apple = 5;
    final int Star = 10;
    final int Mushroom = -5;
    final int wall = -10;
    public boolean isMove = false;
    public final GameBoard gameBoard;
    public Player nowplayer;

    public Move(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setNowplayer(Player nowplayer) {
        this.nowplayer = nowplayer;
    }

    public void movement(int x, int y) {
        if (!isCorrectMove(x, y)) {
            return;
        }
        if (gameBoard.starCounter() > 0) {
            if ((nowplayer.getNowX() == x && nowplayer.getNowY() != y)) {
                for (int i = Math.min(y, nowplayer.getNowY()); i <= Math.max(y, nowplayer.getNowY()); i++) {
                    switch (gameBoard.board[x][i]) {
                        case Star:
                            nowplayer.addPoint();
                            gameBoard.board[x][i] = 0;
                            gameBoard.btnBoard[x][i].setIcon(null);
                            continue;
                        case Apple:
                            nowplayer.addPower();
                            gameBoard.board[x][i] = 0;
                            gameBoard.btnBoard[x][i].setIcon(null);
                            continue;
                        case Mushroom:
                            nowplayer.losePower();
                            gameBoard.board[x][i] = 0;
                            gameBoard.btnBoard[x][i].setIcon(null);
                    }
                }

            } else if ((nowplayer.getNowX() != x && nowplayer.getNowY() == y)) {
                for (int i = Math.min(x, nowplayer.getNowX()); i <= Math.max(x, nowplayer.getNowX()); i++) {
                    switch (gameBoard.board[i][y]) {
                        case Star:
                            gameBoard.board[i][y] = 0;
                            gameBoard.btnBoard[i][y].setIcon(null);
                            nowplayer.addPoint();
                            continue;
                        case Apple:
                            gameBoard.board[i][y] = 0;
                            gameBoard.btnBoard[i][y].setIcon(null);
                            nowplayer.addPower();
                            continue;
                        case Mushroom:
                            gameBoard.board[i][y] = 0;
                            gameBoard.btnBoard[i][y].setIcon(null);
                            nowplayer.losePower();
                    }
                }
            }
            int temp;
            temp = gameBoard.board[nowplayer.getNowX()][nowplayer.getNowY()];
            gameBoard.board[nowplayer.getNowX()][nowplayer.getNowY()] = 0;
            gameBoard.btnBoard[nowplayer.getNowX()][nowplayer.getNowY()].setIcon(null);
            nowplayer.setNowX(x);
            nowplayer.setNowY(y);
            gameBoard.board[nowplayer.getNowX()][nowplayer.getNowY()] = temp;
            if (temp == 1) {
                gameBoard.btnBoard[nowplayer.getNowX()][nowplayer.getNowY()].setIcon(new ImageIcon(new ImageIcon("Image/player1.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
            } else {
                gameBoard.btnBoard[nowplayer.getNowX()][nowplayer.getNowY()].setIcon(new ImageIcon(new ImageIcon("Image/player2.png").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
            }
            isMove = true;
        }
    }

    public boolean isCorrectMove(int x, int y) {
        if (nowplayer.getNowX() != x && nowplayer.getNowY() != y) {
            return false;//orib
        } else if (gameBoard.board[x][y] == 1 || gameBoard.board[x][y] == 2) {
            return false; //forbeden move 2bazikon
        } else if ((nowplayer.getNowX() == x && nowplayer.getNowY() != y)) {
            if (Math.abs(nowplayer.getNowY() - y) > nowplayer.getPower()) {
                return false;//power
            }
            for (int i = Math.min(y, nowplayer.getNowY()); i <= Math.max(y, nowplayer.getNowY()); i++) {
                if (gameBoard.board[x][i] == wall) {
                    return false;//wall
                }
            }
        } else if ((nowplayer.getNowX() != x && nowplayer.getNowY() == y)) {
            if (Math.abs(nowplayer.getNowX() - x) > nowplayer.getPower()) {
                return false;//power
            }

            for (int i = Math.min(x, nowplayer.getNowX()); i <= Math.max(x, nowplayer.getNowX()); i++) {
                if (gameBoard.board[i][y] == wall) {
                    return false;//wall
                }
            }
        }
        return true;
    }
}
