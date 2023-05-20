package GUI;

import Game.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author eby
 */
public class TableListenerOnMainMap implements ActionListener {

    private int round;
    private HammerListener hammerListener;
    private int x;
    private int y;
    private boolean isEndOfGame = false;
    private Player[] players;
    private final JButton pointPlayer1 = new JButton();
    private final JButton pointPlayer2 = new JButton();
    private final JButton namePlayer1 = new JButton();
    private final JButton namePlayer2 = new JButton();
    private final JButton powPlayer1 = new JButton();
    private final JButton powPlayer2 = new JButton();
    private final JButton roundbtn = new JButton("round");

    public TableListenerOnMainMap(JPanel panel) {
        putInformationBtnOnMainMap(panel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String location[] = event.toString().substring(event.toString().indexOf(" on ") + 4).split(" ");
        x = Integer.parseInt(location[0]);
        y = Integer.parseInt(location[1]);
        if (!isEndOfGame) {
            if (hammerListener.isClickedHammer()) {
                if (hammerListener.deletWall(players[round % 2], x, y)) {
                    round++;
                    showPlayInfoPlayer1();
                    showPlayInfoPlayer2();
                    if (players[0].isForbidRound && players[1].isForbidRound) {
                        players[0].isForbidRound = false;
                        players[1].isForbidRound = false;
                    }
                    setRoundColor();
                }
            } else {
                moveListener();
            }
        }  else {
            JOptionPane.showMessageDialog(null, " Game has finished already ");
        }
    }

    public void setPlayers(Player[] players) {
        this.players = players;
        showPlayInfoPlayer1();
        showPlayInfoPlayer2();
    }

    public void moveListener() {

        if (round % 2 == 0) {
            if (!players[0].isForbidRound) {
                players[0].move.setNowplayer(players[0]);
                players[0].move.movement(x, y);
                if (players[0].move.isMove) {
                    players[0].move.isMove = false;
                    if (players[0].isForbidRound && players[1].isForbidRound) {
                        round++;
                        players[0].isForbidRound = false;
                        players[1].isForbidRound = false;
                        setRoundColor();
                    } else if (!players[1].isForbidRound) {
                        round++;
                    } else {
                        players[1].isForbidRound = false;
                    }
                    setRoundColor();
                    showPlayInfoPlayer1();
                }
            }

        } else {
            if (!players[1].isForbidRound) {
                players[1].move.setNowplayer(players[1]);
                players[1].move.movement(x, y);
                if (players[1].move.isMove) {
                    players[1].move.isMove = false;
                    if (players[0].isForbidRound && players[1].isForbidRound) {
                        round++;
                        players[0].isForbidRound = false;
                        players[1].isForbidRound = false;
                        setRoundColor();
                    } else if (!players[0].isForbidRound) {
                        round++;
                    } else {
                        players[0].isForbidRound = false;
                    }
                    setRoundColor();
                    showPlayInfoPlayer2();
                }
            }
        }
        if (!isEndOfGame && players[0].move.gameBoard.starCounter() == 0) {
            isEndOfGame = true;
            showEndGameInformation();
        }
    }

    private void showPlayInfoPlayer1() {
        namePlayer1.setText(players[0].getName());
        namePlayer1.setFont(new Font("Cooper Black", Font.BOLD, 25));
        pointPlayer1.setText("point: " + players[0].getPoint());
        pointPlayer1.setFont(new Font("Cooper Black", Font.BOLD, 25));
        //powPlayer1.setText("pow: " + players[0].getPower());
        players[0].setPower((int)(Math.random() * 5 + 1));
        powPlayer1.setText("pow: " + players[0].getPower());
        powPlayer1.setFont(new Font("Cooper Black", Font.BOLD, 25));
    }

    private void showPlayInfoPlayer2() {
        powPlayer2.setText("pow: " + players[1].getPower());
        powPlayer2.setFont(new Font("Cooper Black", Font.BOLD, 25));
        namePlayer2.setText(players[1].getName());
        namePlayer2.setFont(new Font("Cooper Black", Font.BOLD, 25));
        pointPlayer2.setText("point: " + players[1].getPoint());
        pointPlayer2.setFont(new Font("Cooper Black", Font.BOLD, 25));
    }

    private void showEndGameInformation() {
        showPlayInfoPlayer1();
        showPlayInfoPlayer2();
        setRoundColor();
        if (players[0].getPoint() < players[1].getPoint()) {
            JOptionPane.showMessageDialog(null, players[1].getName() + " Whit " + players[1].getPoint() + " point Wins!!!!");
        } else if (players[0].getPoint() > players[1].getPoint()) {
            JOptionPane.showMessageDialog(null, players[0].getName() + " Whit " + players[0].getPoint() + " point Wins!!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Opps Draw !!!");
        }

    }

    private void setRoundColor() {
        if (round % 2 == 0) {
            roundbtn.setBackground(Color.red);
        } else {
            roundbtn.setBackground(Color.blue);
        }
    }

    private void putInformationBtnOnMainMap(JPanel panel) {
        namePlayer1.setBounds(panel.getWidth() / 20, panel.getWidth() / 20, 250, 70);
        panel.add(namePlayer1);
        namePlayer1.setBackground(Color.red);
        namePlayer1.setForeground(Color.WHITE);
        namePlayer2.setBounds(19 * panel.getWidth() / 20 - 240, panel.getWidth() / 20, 250, 70);
        panel.add(namePlayer2);
        namePlayer2.setBackground(Color.blue);
        namePlayer2.setForeground(Color.WHITE);

        pointPlayer1.setBounds(panel.getWidth() / 20 + 20, panel.getWidth() / 11 - 9, 210, 70);
        panel.add(pointPlayer1);
        pointPlayer1.setBackground(new Color(0, 100, 0));
        pointPlayer1.setForeground(Color.YELLOW);
        pointPlayer2.setBounds(19 * panel.getWidth() / 20 - 220, panel.getWidth() / 11 - 9, 210, 70);
        panel.add(pointPlayer2);
        pointPlayer2.setBackground(new Color(0, 100, 0));
        pointPlayer2.setForeground(Color.YELLOW);

        powPlayer1.setBounds(panel.getWidth() / 20 + 35, 2 * panel.getWidth() / 15 - 20, 180, 70);
        panel.add(powPlayer1);
        powPlayer1.setBackground(Color.yellow);
        powPlayer2.setBounds(19 * panel.getWidth() / 20 - 205, 2 * panel.getWidth() / 15 - 20, 180, 70);
        panel.add(powPlayer2);
        powPlayer2.setBackground(Color.yellow);

        roundbtn.setBounds(panel.getWidth() / 2 - 90, 15, 180, 70);
        panel.add(roundbtn);
        roundbtn.setForeground(Color.yellow);
        roundbtn.setBackground(Color.red);
        roundbtn.setFont(new Font("Cooper Black", Font.BOLD, 25));
    }

    public void setHammerListener(HammerListener hammerListener) {
        this.hammerListener = hammerListener;
    }

}
