import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){

        this.setTitle("Title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420 , 420);//sets the x-dimention and y-dimension of the this
        this.setVisible(true);//make a frame visible

        ImageIcon image = new ImageIcon("ekip.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(128, 11, 243));
    }
}
