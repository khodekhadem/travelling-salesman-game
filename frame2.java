import javax.swing.*;
import java.awt.*;

public class frame2 extends JFrame {

    JFrame frame2 = new JFrame();
    map map_panel;

    frame2() {
        map_panel = new map();

        frame2.add(map_panel);
        //frame2.setResizable(true);
        frame2.setTitle("Traveling_Salesman");
        frame2.setLayout(null);
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setSize(1738 , 977);
        frame2.setVisible(true);

        //this.setSize(1738, 977);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLayout(null);
        //this.setTitle("Traveling_Salesman");
        //this.setVisible(true);
    }

}
