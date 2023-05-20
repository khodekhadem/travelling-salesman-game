package Game;

import javax.swing.JButton;

/**
 *
 * @author eby
 */
public class GameBoard {

    private final int Star = 10;
    public int[][] board;
    public JButton[][] btnBoard;

    public int starCounter() {
        int starCountOfBoard = 0;
        for (int[] arrayElement : board) {
            for (int element : arrayElement) {
                if (element == Star) {
                    starCountOfBoard++;
                }
            }
        }
        return starCountOfBoard;
    }
}
