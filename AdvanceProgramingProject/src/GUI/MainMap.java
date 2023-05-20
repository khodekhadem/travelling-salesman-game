package GUI;
import java.util.concurrent.TimeUnit;
import Game.HostGameMode;
import Game.HostLoop;
import Game.JoinGameMode;
import Game.JoinLoop;
import Game.Variables;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eby
 */
public class MainMap {

    private final int squerLine;
    JFrame frame = new JFrame("Stars Game");
    private final JPanel panel = new JPanel();
    final MapCreator map;
    public TableListenerOnMainMap tableListenerOnMainMap;
    private final HammerListener hammerListener = new HammerListener();
    private final JButton menuButton = new JButton();
    private final JButton hammer = new JButton();
    private final JLabel label = new JLabel();
    private JoinLoop joinLoop;
    private HostLoop hostLoop;

    public MainMap(MapCreator map) {
        this.map = map;
        map.getFrame().dispose();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, (int) windowSize.getWidth(), (int) windowSize.getHeight());
        panel.setBounds(0, 0, (int) windowSize.getWidth(), (int) windowSize.getHeight());
        label.setBounds(0, 0, (int) windowSize.getWidth(), (int) windowSize.getHeight());
        ImageIcon image = new ImageIcon(new ImageIcon("Image/game.jpg").getImage().getScaledInstance((int) windowSize.getWidth(), (int) windowSize.getHeight(), Image.SCALE_SMOOTH));
        label.setIcon(image);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        panel.setLayout(null);
        panel.setOpaque(true);
        frame.add(panel);
        if (map.game instanceof HostGameMode) {
            hostLoop = new HostLoop(panel);
        } else if (map.game instanceof JoinGameMode) {
            joinLoop = new JoinLoop(panel);
        } else {
            tableListenerOnMainMap = new TableListenerOnMainMap(panel);
            //wait(2000);
        }
        squerLine = initializeSquerLine();
        drawGameTable();
    }

    private void drawGameTable() {

        for (int i = 0; i < Variables.getRow(); i++) {
            for (int j = 0; j < Variables.getCool(); j++) {
                map.game.board.btnBoard[i][j].setBounds(frame.getWidth() / 2 - Variables.getCool() * squerLine / 2 + j * (squerLine + 1), (squerLine + 1) * i + frame.getHeight() / 2 - Variables.getRow() * squerLine / 2 - squerLine / 4, squerLine, squerLine);
                map.game.board.btnBoard[i][j].setBackground(Color.GREEN);
                map.game.board.btnBoard[i][j].setName(i + " " + j);
                panel.add(map.game.board.btnBoard[i][j]);
                map.game.board.btnBoard[i][j].removeActionListener(map.tableListenerOnMapCreator);
                if (map.game instanceof HostGameMode) {
                    map.game.board.btnBoard[i][j].addActionListener(hostLoop);
                } else if (map.game instanceof JoinGameMode) {
                    map.game.board.btnBoard[i][j].addActionListener(joinLoop);
                } else {
                    map.game.board.btnBoard[i][j].addActionListener(tableListenerOnMainMap);
                }
                if (map.game.board.board[i][j] == 10) {
                    System.out.println("sleep"+i+j);
                    //Thread.sleep(500);
                    map.game.board.btnBoard[i][j].setIcon(new ImageIcon(new ImageIcon("Image/star.gif").getImage().getScaledInstance(Variables.squerLine, Variables.squerLine, java.awt.Image.SCALE_DEFAULT)));
                }
                panel.add(map.game.board.btnBoard[i][j]);
            }
        }
        putNewGameBtn();
        putHammerBtn();
        panel.add(label);
        frame.setVisible(true);
        panel.setVisible(true);
    }

    private void putNewGameBtn() {
        menuButton.setBounds(map.getObjectSquerLine() / 4, frame.getHeight() - 5 * map.getObjectSquerLine() / 4, 5 * map.getObjectSquerLine() / 4, map.getObjectSquerLine() / 2);
        menuButton.setBackground(Color.BLACK);
        menuButton.setForeground(Color.GREEN);
        menuButton.setName("menu");
        menuButton.setText("Menu");
        menuButton.setFont(new Font("Cooper Black", Font.CENTER_BASELINE,50));
        panel.add(menuButton);
        menuButton.addActionListener(new MenuListenerOnMap(this));

    }

    private void putHammerBtn() {
        hammer.setBounds(frame.getWidth() - 6 * map.getObjectSquerLine() / 4, frame.getHeight() - 5 * map.getObjectSquerLine() / 4, 5 * map.getObjectSquerLine() / 4, map.getObjectSquerLine() / 2);
        hammer.setBackground(Color.yellow);
        hammer.setName("hammer");
        hammer.setIcon(new ImageIcon(new ImageIcon("Image/hammer.png").getImage().getScaledInstance(5 * map.getObjectSquerLine() / 4, map.getObjectSquerLine() / 2, java.awt.Image.SCALE_DEFAULT)));
        panel.add(hammer);
        hammer.addActionListener(hammerListener);
        if (map.game instanceof HostGameMode) {
            hostLoop.setHammerListener(hammerListener);
        } else if (map.game instanceof JoinGameMode) {
            joinLoop.setHammerListener(hammerListener);
        } else {
            tableListenerOnMainMap.setHammerListener(hammerListener);
        }
    }
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    private int initializeSquerLine() {
        if (Math.max(Variables.getRow(), Variables.getCool()) < 6) {
            return 150;
        } else if (Math.max(Variables.getRow(), Variables.getCool()) < 9) {
            return 100;
        } else if (Math.max(Variables.getRow(), Variables.getCool()) < 11) {
            return 85;
        } else if (Math.max(Variables.getRow(), Variables.getCool()) < 13) {
            return 75;

        } else if (Math.max(Variables.getRow(), Variables.getCool()) < 15) {
            return 60;
        } else {
            return 810 / (Math.max(Variables.getRow(), Variables.getCool()));
        }
    }

    public JoinLoop getJoinLoop() {
        return joinLoop;
    }

    public HostLoop getHostLoop() {
        return hostLoop;
    }
    

}
