import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame3 extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    ImageIcon xicon;
    ImageIcon checkicon;
    MyFrame3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        checkicon = new ImageIcon("img/check.png");
        xicon = new ImageIcon("img/remove.png");

        button = new JButton();
        button.setText("Submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("I'm not a Robot");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas" , Font.PLAIN , 35));
        checkBox.setIcon(xicon);
        checkBox.setSelectedIcon(checkicon);

        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            System.out.println(checkBox.isSelected());
        }
    }
}
