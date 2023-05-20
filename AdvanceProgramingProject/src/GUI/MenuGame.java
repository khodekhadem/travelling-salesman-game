package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eby
 */
public class MenuGame {

    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private final JLabel lable = new JLabel();
    private final JButton host = new JButton("Host");
    private final JButton join = new JButton("Join");
    private final JButton twoPlayer = new JButton("TwoPlayer");
    private final JButton exit = new JButton("Exit");
    private final NewHost hostListener = new NewHost(this);
    private final NewJoin joinListener = new NewJoin(this);
    Font menuButtonFont = new Font("Cooper Black", Font.BOLD, 60);
    private final NewTwoPlayerGame twoPlayerListener = new NewTwoPlayerGame(this);

    public MenuGame() {
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, (int) windowSize.getWidth(), (int) windowSize.getHeight());
        panel.setBounds(0, 0, (int) windowSize.getWidth(), (int) windowSize.getHeight());
        lable.setBounds(0, 0, (int) windowSize.getWidth(), (int) windowSize.getHeight());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        panel.setLayout(null);
        lable.setLayout(null);
        lable.setIcon(new ImageIcon(new ImageIcon("Image//menu.png").getImage().getScaledInstance((int) windowSize.getWidth(), (int) windowSize.getHeight(), Image.SCALE_AREA_AVERAGING)));
        panel.add(lable);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonMenuSiting();
        frame.setVisible(true);
    }

    private void buttonMenuSiting() {
        twoPlayer.setBounds(panel.getWidth() / 2 - 200, panel.getHeight() / 5, 400, 100);
        host.setBounds(panel.getWidth() / 2 - twoPlayer.getWidth() / 2, panel.getHeight() / 5 + 5 * twoPlayer.getHeight() / 4, twoPlayer.getWidth(), twoPlayer.getHeight());
        join.setBounds(panel.getWidth() / 2 - twoPlayer.getWidth() / 2, panel.getHeight() / 5 + 10 * twoPlayer.getHeight() / 4, twoPlayer.getWidth(), twoPlayer.getHeight());
        exit.setBounds(panel.getWidth() / 2 - twoPlayer.getWidth() / 2, panel.getHeight() / 5 + 15 * twoPlayer.getHeight() / 4, twoPlayer.getWidth(), twoPlayer.getHeight());

        twoPlayer.setFont(menuButtonFont);
        host.setFont(menuButtonFont);
        join.setFont(menuButtonFont);
        exit.setFont(menuButtonFont);

        twoPlayer.setBackground(Color.YELLOW);
        host.setBackground(Color.YELLOW);
        join.setBackground(Color.YELLOW);
        exit.setBackground(Color.YELLOW);

        twoPlayer.addActionListener(twoPlayerListener);
        host.addActionListener(hostListener);
        join.addActionListener(joinListener);
        exit.addActionListener((e) -> {
            frame.dispose();
        });
        
        setMouseListener();
        lable.add(host);
        lable.add(join);
        lable.add(twoPlayer);
        lable.add(exit);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setMouseListener() {
        twoPlayer.addMouseListener(new MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                twoPlayer.setBackground(Color.GREEN);
                twoPlayer.setForeground(Color.red);
                twoPlayer.setBounds(panel.getWidth() / 2 - 5 * twoPlayer.getWidth() / 8, panel.getHeight() / 5, 5 * twoPlayer.getWidth() / 4, 100);
                twoPlayer.setFont(new Font("Cooper Black", Font.BOLD, 70));

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                twoPlayer.setBackground(Color.YELLOW);
                twoPlayer.setForeground(Color.BLACK);
                twoPlayer.setBounds(panel.getWidth() / 2 - 200, panel.getHeight() / 5, 400, 100);
                twoPlayer.setFont(menuButtonFont);

            }
        });

        host.addMouseListener(new MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                host.setBackground(Color.GREEN);
                host.setForeground(Color.red);
                host.setBounds(panel.getWidth() / 2 - 5 * twoPlayer.getWidth() / 8, panel.getHeight() / 5 + 5 * twoPlayer.getHeight() / 4, 5 * twoPlayer.getWidth() / 4, twoPlayer.getHeight());
                host.setFont(new Font("Cooper Black", Font.BOLD, 70));

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                host.setBackground(Color.YELLOW);
                host.setForeground(Color.BLACK);
                host.setBounds(panel.getWidth() / 2 - twoPlayer.getWidth() / 2, panel.getHeight() / 5 + 5 * twoPlayer.getHeight() / 4, twoPlayer.getWidth(), twoPlayer.getHeight());
                host.setFont(menuButtonFont);

            }
        });

        join.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                join.setBackground(Color.GREEN);
                join.setForeground(Color.red);
                join.setBounds(panel.getWidth() / 2 - 5 * twoPlayer.getWidth() / 8, panel.getHeight() / 5 + 10 * twoPlayer.getHeight() / 4, 5 * twoPlayer.getWidth() / 4, twoPlayer.getHeight());
                join.setFont(new Font("Cooper Black", Font.BOLD, 70));

            }
 
            
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                join.setBackground(Color.YELLOW);
                join.setForeground(Color.BLACK);
                join.setBounds(panel.getWidth() / 2 - twoPlayer.getWidth() / 2, panel.getHeight() / 5 + 10 * twoPlayer.getHeight() / 4, twoPlayer.getWidth(), twoPlayer.getHeight());
                join.setFont(menuButtonFont);

            }
        });

        exit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit.setBackground(Color.GREEN);
                exit.setForeground(Color.red);
                exit.setBounds(panel.getWidth() / 2 - 5 * twoPlayer.getWidth() / 8, panel.getHeight() / 5 + 15 * twoPlayer.getHeight() / 4, 5 * twoPlayer.getWidth() / 4, twoPlayer.getHeight());
                exit.setFont(new Font("Cooper Black", Font.BOLD, 70));

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit.setBackground(Color.YELLOW);
                exit.setForeground(Color.BLACK);
                exit.setBounds(panel.getWidth() / 2 - twoPlayer.getWidth() / 2, panel.getHeight() / 5 + 15 * twoPlayer.getHeight() / 4, twoPlayer.getWidth(), twoPlayer.getHeight());
                exit.setFont(menuButtonFont);

            }
        });
    }
}
