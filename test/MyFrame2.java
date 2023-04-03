import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame implements ActionListener {

    JButton jButton;
    JTextField textfeild;
    MyFrame2(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        jButton = new JButton("Submit");
        jButton.addActionListener(this);
        textfeild = new JTextField();
        textfeild.setPreferredSize(new Dimension(250 , 40));
        textfeild.setFont(new Font("Consolas" ,Font.PLAIN , 35));
        textfeild.setForeground(new Color(0x00FF00));
        textfeild.setBackground(Color.BLACK);
        textfeild.setCaretColor(Color.white);
        textfeild.setText("username");
        textfeild.setEditable(false);

        this.add(textfeild);
        this.add(jButton);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton){
            System.out.println("Wellcome " + textfeild.getText());
            setEnabled(false);
            textfeild.setEditable(false);
        }
    }
}
