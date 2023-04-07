import javax.swing.*;
import java.awt.*;

public class map extends JPanel {

    Image castle;
    map() {
        castle = new ImageIcon("img/moon.jpg").getImage();
        this.setBounds(0 , 0 , 1738 , 977);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        //Main Board
        g2D.setPaint(Color.WHITE);
        g2D.drawRect(0, 0, 1738, 977);

        //Background
        g2D.setPaint(Color.lightGray);
        g2D.fillRoundRect(40 , 40 , 770 , 770 , 15 , 15);

        //Mao of game
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g2D.setPaint(Color.gray);
                g2D.fillRoundRect(50 + i * 75 , 50 + j * 75 , 70 , 70 , 15 , 15);
            }
        }
        //Starting Point
        g2D.setPaint(Color.magenta);
        g2D.fillOval(45 , 820 , 80, 80);
        g2D.setPaint(Color.BLACK);
        g2D.setFont(new Font("Ink Free", Font.PLAIN, 20));
        g2D.drawString("Start" , 60 , 870);
        //Castle
        g2D.drawImage(castle , 425 , 350 , null);
        //Walls
        g2D.setPaint(Color.BLACK);
        g2D.fillRoundRect(125 , 50 , 70 , 70 , 15 , 15);
        g2D.fillRoundRect(50 , 650 , 70 , 70 , 15 , 15);
        g2D.fillRoundRect(50 , 350 , 70 , 70 , 15 , 15);
        g2D.fillRoundRect(650 , 50 , 70 , 70 , 15 , 15);
        g2D.fillRoundRect(725 , 500 , 70 , 70 , 15 , 15);
        //Traps
    }
}
