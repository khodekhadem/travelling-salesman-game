import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Graphicsclass extends JFrame {
    int count = 0 ;
    //primitive variables
    Mypanel panel;
    map map_panel;
    JFrame frame = new JFrame();
    JProgressBar progressBar = new JProgressBar();
    //constructor
    Graphicsclass(){
        panel = new Mypanel();
        map_panel = new map();

        progressBar.setValue(0);
        progressBar.setBounds(0 , 867 , 1738, 77);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("MV Boli", Font.BOLD , 25));
        progressBar.setForeground(Color.BLUE);
        progressBar.setBackground(Color.WHITE);

        //frame.add(progressBar);
        frame.setSize(1738 , 977);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setPreferredSize(new Dimension(1738 , 977));
        //frame.add(panel);
        frame.add(map_panel);
        frame.setTitle("Traveling_Salesman");
        //this.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        fill();
    }
    public void fill(){
        while (count <= 100){
            progressBar.setValue(count);
            progressBar.setString("Loading " + count + "%");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count += 1;
        }
        progressBar.setString(" Wellcome :) ");
    }
}
