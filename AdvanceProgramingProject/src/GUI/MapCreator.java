package GUI;

import Game.Game;
import Game.JoinGameMode;
import Game.Variables;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author eby
 */


public final class MapCreator {

    public final Game game;
    private int objectSquerLine;
    private final int endOfBoard;
    private final JFrame frame = new JFrame("Map Createor");
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel();
    private final JButton firstPlayer = new JButton();
    private final JButton secendPlayer = new JButton();
    private final JButton star = new JButton();
    private final JButton apple = new JButton();
    private final JButton mushRoom = new JButton();
    private final JButton wall = new JButton();
    private final JButton start = new JButton();
    private final JButton remove = new JButton();
    private final JButton reSize = new JButton();
    private final JButton newMap = new JButton("New Map");
    private final JButton menuButton = new JButton("Menu");
    TableListenerOnMapCreator tableListenerOnMapCreator;
    ObjectListenerOnMapCreator objectListenerOnMapCreator;
    ThreadForSendMapCrratorDataToClient threadForSendMapCrratorDataToClient;

    public MapCreator(Game game) {
        this.game = game;
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, (int) windowSize.getWidth(), (int) windowSize.getHeight() - 70);
        panel.setBounds(0, 0, (int) windowSize.getWidth(), (int) windowSize.getHeight() - 70);
        label.setBounds(0, 0, (int) windowSize.getWidth(), (int) windowSize.getHeight() - 70);
        ImageIcon image = new ImageIcon(new ImageIcon("Image//mapCreator.jpg").getImage().getScaledInstance((int) windowSize.getWidth(), (int) windowSize.getHeight(), Image.SCALE_SMOOTH));
         
        label.setIcon(image);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setOpaque(true);
        panel.setLayout(null);
        label.setLayout(null);
        frame.add(panel);
        game.board.btnBoard = new JButton[Variables.getRow()][Variables.getCool()];
        game.board.board = new int[Variables.getRow()][Variables.getCool()];
        tableListenerOnMapCreator = new TableListenerOnMapCreator(this.game);
        objectListenerOnMapCreator = new ObjectListenerOnMapCreator(tableListenerOnMapCreator);
        Variables.squerLine = initializeSquerLine();
        endOfBoard = (((Variables.squerLine + 1) * (Variables.getCool() - 1) + 8 * frame.getHeight() / 10 - Variables.getCool() * Variables.squerLine / 2 + Variables.squerLine));
        setObjectBtnName();
        frame.repaint();
        drawMap();
    }

    public void drawMap() {
        objectSquerLine = initializeObjectSquerLine();
        takeObjectBtnOnMapCreator();
        for (int i = 0; i < Variables.getRow(); i++) {
            for (int j = 0; j < Variables.getCool(); j++) {
                game.board.btnBoard[i][j] = new JButton();
                game.board.btnBoard[i][j].setBounds((Variables.squerLine + 1) * j + 8 * frame.getHeight() / 10 - Variables.getCool() * Variables.squerLine / 2, (Variables.squerLine + 1) * i + frame.getHeight() / 2 - Variables.getRow() * Variables.squerLine / 2, Variables.squerLine, Variables.squerLine);
                game.board.btnBoard[i][j].setBackground(Color.yellow);
                game.board.btnBoard[i][j].setName(i + " " + j);
                if (!(game instanceof JoinGameMode)) {
                    game.board.btnBoard[i][j].addActionListener(tableListenerOnMapCreator);
                }
                panel.add(game.board.btnBoard[i][j]);
            }
        }
        panel.add(label);
        panel.setVisible(true);
        frame.setVisible(true);
        if (game instanceof JoinGameMode) {
            threadForSendMapCrratorDataToClient = new ThreadForSendMapCrratorDataToClient(game);
            threadForSendMapCrratorDataToClient.start();
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
            return 800 / (Math.max(Variables.getRow(), Variables.getCool()));
        }
    }

    private int initializeObjectSquerLine() {
        return 155;
    }

    public JFrame getFrame() {
        return frame;
    }

    private void setObjectBtnName() {
        firstPlayer.setName("firstPlayer");
        secendPlayer.setName("secendPlayer");
        star.setName("star");
        apple.setName("apple");
        mushRoom.setName("mushRoom");
        wall.setName("wall");
        start.setName("start");
        remove.setName("remove");
    }

    public int getObjectSquerLine() {
        return objectSquerLine;
    }

    private void takeObjectBtnOnMapCreator() {
        firstPlayer.setBounds(endOfBoard + 3 * objectSquerLine / 4, frame.getHeight() / 15, objectSquerLine, objectSquerLine);
        panel.add(firstPlayer);
        if (!(game instanceof JoinGameMode)) {
            firstPlayer.addActionListener(objectListenerOnMapCreator);
        }
        firstPlayer.setIcon(new ImageIcon(new ImageIcon("Image/player1.png").getImage().getScaledInstance(objectSquerLine, objectSquerLine, java.awt.Image.SCALE_DEFAULT)));
        firstPlayer.setBackground(Color.WHITE);
        secendPlayer.setBounds(endOfBoard + 2 * objectSquerLine, frame.getHeight() / 15, objectSquerLine, objectSquerLine);
        panel.add(secendPlayer);
        if (!(game instanceof JoinGameMode)) {
            secendPlayer.addActionListener(objectListenerOnMapCreator);
        }
        secendPlayer.setIcon(new ImageIcon(new ImageIcon("Image/player2.png").getImage().getScaledInstance(objectSquerLine, objectSquerLine, java.awt.Image.SCALE_DEFAULT)));
    secendPlayer.setBackground(Color.WHITE);
        star.setBounds(endOfBoard + 3 * objectSquerLine / 4, frame.getHeight() / 15 + 3 * objectSquerLine / 2, objectSquerLine, objectSquerLine);
        panel.add(star);
        //star.setBackground(new Color(0, 0, 180));
        if (!(game instanceof JoinGameMode)) {
            star.addActionListener(objectListenerOnMapCreator);
        }
        star.setIcon(new ImageIcon(new ImageIcon("Image/star.png").getImage().getScaledInstance(objectSquerLine, objectSquerLine, java.awt.Image.SCALE_DEFAULT)));
        star.setBackground(Color.WHITE);
        
        
        apple.setBounds(endOfBoard + 2 * objectSquerLine, frame.getHeight() / 15 + 3 * objectSquerLine / 2, objectSquerLine, objectSquerLine);
        panel.add(apple);
        apple.setBackground(Color.white);
        if (!(game instanceof JoinGameMode)) {
            apple.addActionListener(objectListenerOnMapCreator);
        }
        apple.setIcon(new ImageIcon(new ImageIcon("Image/apple.png").getImage().getScaledInstance(objectSquerLine, objectSquerLine, java.awt.Image.SCALE_DEFAULT)));

        mushRoom.setBounds(endOfBoard + 3 * objectSquerLine / 4, frame.getHeight() / 15 + 3 * objectSquerLine, objectSquerLine, objectSquerLine);
        panel.add(mushRoom);
        mushRoom.setBackground(Color.WHITE);
        if (!(game instanceof JoinGameMode)) {
            mushRoom.addActionListener(objectListenerOnMapCreator);
        }
        mushRoom.setIcon(new ImageIcon(new ImageIcon("Image/mushRoom.png").getImage().getScaledInstance(objectSquerLine, objectSquerLine, java.awt.Image.SCALE_DEFAULT)));

        wall.setBounds(endOfBoard + 2 * objectSquerLine, frame.getHeight() / 15 + 3 * objectSquerLine, objectSquerLine, objectSquerLine);
        panel.add(wall);
        if (!(game instanceof JoinGameMode)) {
            wall.addActionListener(objectListenerOnMapCreator);
        }
        wall.setIcon(new ImageIcon(new ImageIcon("Image/wall.jfif").getImage().getScaledInstance(objectSquerLine + 15, objectSquerLine, java.awt.Image.SCALE_DEFAULT)));

        start.setBounds(endOfBoard + 11 * objectSquerLine / 8, frame.getHeight() - objectSquerLine, objectSquerLine, objectSquerLine / 2);
        panel.add(start);
        if (!(game instanceof JoinGameMode)) {
            start.addActionListener(objectListenerOnMapCreator);
        }
        start.setBackground(Color.green.darker());
        start.setIcon(new ImageIcon(new ImageIcon("Image/playButton.png").getImage().getScaledInstance(objectSquerLine, objectSquerLine / 2, java.awt.Image.SCALE_DEFAULT)));
        start.setVisible(false);

        remove.setBounds(endOfBoard + 3 * objectSquerLine / 4, frame.getHeight() - 5 * objectSquerLine / 3, objectSquerLine, objectSquerLine / 2);
        panel.add(remove);
        if (!(game instanceof JoinGameMode)) {
            remove.addActionListener(objectListenerOnMapCreator);
        }
        remove.setBackground(Color.WHITE);
        remove.setIcon(new ImageIcon(new ImageIcon("Image/remove.png").getImage().getScaledInstance(3 * objectSquerLine / 4, objectSquerLine / 2, java.awt.Image.SCALE_DEFAULT)));

        reSize.setBounds(objectSquerLine / 2, objectSquerLine/2, objectSquerLine, objectSquerLine / 2);
        reSize.setBackground(Color.BLACK);
        reSize.setForeground(Color.YELLOW);
        reSize.setFont(new Font("Cooper Black", Font.BOLD, 33));
        reSize.setText("Resize");
        reSize.setName("RESIZE");
        panel.add(reSize);
        if (!(game instanceof JoinGameMode)) {
            reSize.addActionListener(objectListenerOnMapCreator);
        }
        newMap.setBounds(endOfBoard + 2 * objectSquerLine, frame.getHeight() - 5 * objectSquerLine / 3, objectSquerLine, objectSquerLine / 2);
        newMap.setBackground(Color.BLACK);
        newMap.setForeground(Color.WHITE);
        newMap.setFont(new Font("Cooper Black", Font.CENTER_BASELINE, 22));
        newMap.setName("newMap");
        if (!(game instanceof JoinGameMode)) {
            newMap.addActionListener(objectListenerOnMapCreator);
        }
        panel.add(newMap);
        
        menuButton.setBounds(objectSquerLine / 2, frame.getHeight()-objectSquerLine, objectSquerLine, objectSquerLine / 2);
        menuButton.setFont(new Font("Cooper Black", Font.CENTER_BASELINE,40));
        menuButton.setBackground(Color.BLUE);
        menuButton.setForeground(Color.yellow);
        menuButton.addActionListener(new MenuListenerOnMap(this));
        panel.add(menuButton);
    }

    public JButton getStartBtn() {
        return start;
    }
}

class ThreadForSendMapCrratorDataToClient extends Thread {

    Game game;

    public ThreadForSendMapCrratorDataToClient(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        super.run();
        MapCreatorListenerOfServer joinGameCreateMapIcon = new MapCreatorListenerOfServer((JoinGameMode) game);
        joinGameCreateMapIcon.putObjectOnClientMap();

    }

}
