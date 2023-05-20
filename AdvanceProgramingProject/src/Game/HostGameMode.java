package Game;

/**
 *
 * @author eby
 */
public class HostGameMode extends Game {

    @Override
    public void createPlayers() {
        move = new Move(board);
        for (int i = 0; i < 2; i++) {
            player[i] = new Player(move);
        }
        player[0].setName("You");
        player[1].setName("Opponent");
        findPrimeLocationOfPlayer();
    }
}
