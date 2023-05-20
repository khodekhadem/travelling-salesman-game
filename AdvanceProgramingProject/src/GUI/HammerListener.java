package GUI;

import Game.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author eby
 */
public class HammerListener implements ActionListener {

    final int Wall = -10;
    private boolean clickedHammer = false;

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!clickedHammer) {
            JOptionPane.showMessageDialog(null, "hammer selected! \n for unselect hammer click on hammer again");
            clickedHammer = true;
        } else if (clickedHammer) {
            clickedHammer = false;
        }
    }

    public boolean deletWall(Player player, int i, int j) {
        if (player.move.gameBoard.board[i][j] == Wall) {
            System.out.println("walis "+i+" "+j+"and "+player.move.gameBoard.board[i][j]);
            int answer = JOptionPane.showConfirmDialog(null, "For remove this wall your power will be reduced to " + (player.getPower() - 1) + " Do you want to continue?", "Attention", JOptionPane.YES_NO_OPTION);
            switch (answer) {
                case JOptionPane.CLOSED_OPTION:
                case JOptionPane.NO_OPTION:
                    clickedHammer = false;
                    return false;
                case JOptionPane.YES_OPTION :
                    clickedHammer = false;
                    player.move.gameBoard.board[i][j] = 0;
                    player.move.gameBoard.btnBoard[i][j].setIcon(null);
                    player.losePower();
                    return true;
            }

        }
        else{
            for (int j2 = 0; j2 < 10; j2++) {
                for (int k = 0; k < 10; k++) {
                    System.out.print(player.move.gameBoard.board[j2][k]);
                }
                System.out.println("");
            }
        }
        return false;
    }

    public boolean isClickedHammer() {
        return clickedHammer;
    }

}
