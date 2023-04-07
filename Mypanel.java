import javax.swing.*;
import java.awt.*;

public class Mypanel extends JPanel {
    //primitive variables
    Image backgroundimage;

    //constructor
    Mypanel() {
        this.setLayout(null);
        this.setVisible(true);
        this.setBounds(0, 0, 1738, 867);
        backgroundimage = new ImageIcon("img/background.jpg").getImage();
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        //background image
        g2D.drawImage(backgroundimage, 0, 0, null);

        //Traveling Salesman Text
        g2D.setPaint(new Color( 90 ,  90 , 255));
        g2D.setFont(new Font("Ink Free", Font.PLAIN, 100));
        g2D.drawString("Traveling Salesman", 150, 470);

        //g2D.setPaint(Color.PINK);
        //g2D.setStroke(new BasicStroke(5));
        //g2D.drawLine(0, 0, 500, 500);
        //g2D.drawRect(0, 0, 100 , 200);

        //g2D.fillRect(0 , 0, 100 , 200);
        //g2D.drawOval(0 , 0, 100 ,100);
        //g2D.fillOval(0 , 0, 100 ,100);

        //g2D.setPaint(Color.RED);
        //g2D.drawArc( 0, 0 , 100 , 100 , 0 , 180);
        //g2D.fillArc(0 , 0 ,100 ,100 , 0 ,180);
        //g2D.setPaint(Color.white);
        //g2D.fillArc(0, 0 , 100 , 100 , 180 , 180);

//        int[] xpoints = {150 , 250 , 350};
//        int[] ypoints = {300 , 150 , 300};
//        g2D.setPaint(Color.YELLOW);
//        //g2D.drawPolygon(xpoints , ypoints , 3);
//        g2D.fillPolygon(xpoints , ypoints , 3);
    }
}
