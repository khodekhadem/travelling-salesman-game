package Game;

import GUI.HammerListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author eby
 */
public class HostLoop implements ActionListener {

    int round;
    private HammerListener hammerListener;
    int x;
    int y;
    boolean isEndOfGame = false;
    Player[] players;
    private final JButton pointPlayer1 = new JButton();
    private final JButton pointPlayer2 = new JButton();
    private final JButton namePlayer1 = new JButton();
    private final JButton namePlayer2 = new JButton();
    private final JButton powPlayer1 = new JButton();
    private final JButton powPlayer2 = new JButton();
    private final JButton roundbtn = new JButton("round");
    private ThearedForReceiveDataFramClient takeNewOpponentLocation;
    boolean isThearedRun = false;

    public HostLoop(JPanel panel) {
        putInformationBtnOnMainMap(panel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (round % 2 == 1) {
            JOptionPane.showMessageDialog(null, "Please wait until Opponent move");
            return;
        }
        String location[] = event.toString().substring(event.toString().indexOf(" on ") + 4).split(" ");
        x = Integer.parseInt(location[0]);
        y = Integer.parseInt(location[1]);

        if (!isEndOfGame) {
            if (hammerListener.isClickedHammer()) {
                if (hammerListener.deletWall(players[round % 2], x, y)) {
                    updatePlayerInfoWhenHammerSelected();
                    try {
                        Variables.server.getOutputStream().writeUTF("hammer" + " " + x + " " + y);
                        System.out.println("data hammer send for Client");
                        if (!isThearedRun) {
                            takeNewOpponentLocation = new ThearedForReceiveDataFramClient(this);
                            takeNewOpponentLocation.start();
                            isThearedRun = true;
                        }
                    } catch (IOException iOException) {
                        JOptionPane.showMessageDialog(null, "Connection Feild !!");
                    }
                }
            } else {
                moveListener();
            }
        } else {
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
                    try {
                        Variables.server.getOutputStream().writeUTF(x + " " + y);
                        System.out.println("data send for client");
                    } catch (IOException iOException) {
                        JOptionPane.showMessageDialog(null, "Connection Feild !!");
                    }
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
        }
        if (!isEndOfGame && players[0].move.gameBoard.starCounter() == 0) {
            isEndOfGame = true;
            showEndGameInformation();
        }
        System.out.println(isThearedRun);
        if (round % 2 == 1 && !isThearedRun) {
            takeNewOpponentLocation = new ThearedForReceiveDataFramClient(this);
            takeNewOpponentLocation.start();
            isThearedRun = true;
        }
    }

    void updatePlayerInfoWhenHammerSelected() {
        round++;
        showPlayInfoPlayer1();
        showPlayInfoPlayer2();
        setRoundColor();
    }

    void showPlayInfoPlayer1() {
        namePlayer1.setText(players[0].getName());
        namePlayer1.setFont(new Font("Cooper Black", Font.BOLD, 25));
        pointPlayer1.setText("point: " + players[0].getPoint());
        pointPlayer1.setFont(new Font("Cooper Black", Font.BOLD, 25));
        powPlayer1.setText("pow: " + players[0].getPower());
        powPlayer1.setFont(new Font("Cooper Black", Font.BOLD, 25));
    }

    void showPlayInfoPlayer2() {
        powPlayer2.setText("pow: " + players[1].getPower());
        powPlayer2.setFont(new Font("Cooper Black", Font.BOLD, 25));
        namePlayer2.setText(players[1].getName());
        namePlayer2.setFont(new Font("Cooper Black", Font.BOLD, 25));
        pointPlayer2.setText("point: " + players[1].getPoint());
        pointPlayer2.setFont(new Font("Cooper Black", Font.BOLD, 25));
    }

    void showEndGameInformation() {
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

    void setRoundColor() {
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

class ThearedForReceiveDataFramClient extends Thread {

    HostLoop hostLoop;

    @Override
    public void run() {
        super.run();
        while (!hostLoop.isEndOfGame) {
            if (!hostLoop.players[1].isForbidRound) {
                String[] posittion = null;
                try {
                    posittion = Variables.server.getInputStream().readUTF().split(" ");
                    System.out.println("data recive fram Client");
                    hostLoop.x = Integer.parseInt(posittion[0]);
                    hostLoop.y = Integer.parseInt(posittion[1]);
                    hostLoop.players[1].move.setNowplayer(hostLoop.players[1]);
                    hostLoop.players[1].move.movement(hostLoop.x, hostLoop.y);
                    if (hostLoop.players[1].move.isMove) {
                        hostLoop.players[1].move.isMove = false;
                        if (hostLoop.players[0].isForbidRound && hostLoop.players[1].isForbidRound) {
                            hostLoop.round++;
                            hostLoop.players[0].isForbidRound = false;
                            hostLoop.players[1].isForbidRound = false;
                            hostLoop.setRoundColor();
                            break;
                        } else if (!hostLoop.players[0].isForbidRound) {
                            hostLoop.round++;
                            hostLoop.setRoundColor();
                            hostLoop.showPlayInfoPlayer2();
                            hostLoop.showPlayInfoPlayer1();
                            break;
                        } else {
                            hostLoop.players[0].isForbidRound = false;
                        }
                        hostLoop.setRoundColor();
                        hostLoop.showPlayInfoPlayer2();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Connection Feild !!");
                    break;
                } catch (NumberFormatException ex) {
                    if (posittion[0]!=null && "hammer".equals(posittion[0])) {
                        hostLoop.x = Integer.parseInt(posittion[1]);
                        hostLoop.y = Integer.parseInt(posittion[2]);
                        hostLoop.updatePlayerInfoWhenHammerSelected();
                        JOptionPane.showMessageDialog(null, "Your Oppenent destroyed a wall");
                        hostLoop.players[1].move.gameBoard.board[hostLoop.x][hostLoop.y] = 0;
                        hostLoop.players[1].move.gameBoard.btnBoard[hostLoop.x][hostLoop.y].setIcon(null);
                        hostLoop.players[1].losePower();
                        break;
                    }
                }
            }
        }
        hostLoop.isThearedRun = false;
        if (!hostLoop.isEndOfGame && hostLoop.players[0].move.gameBoard.starCounter() == 0) {
            hostLoop.isEndOfGame = true;
            hostLoop.showEndGameInformation();
        }
    }

    public ThearedForReceiveDataFramClient(HostLoop hostLoop) {
        this.hostLoop = hostLoop;
    }

}
