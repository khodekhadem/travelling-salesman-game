package Game;

import javax.swing.JOptionPane;

/**
 *
 * @author eby
 */
public class JoinGameMode extends Game {

    @Override
    public void createPlayers() {
        move = new Move(board);
        for (int i = 0; i < 2; i++) {
            player[i] = new Player(move);
        }
        player[0].setName("Oppenent");
        player[1].setName("You");
        findPrimeLocationOfPlayer();
    }
}
