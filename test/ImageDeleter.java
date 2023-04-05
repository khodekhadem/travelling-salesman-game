import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageDeleter extends JFrame implements MouseListener {
    private JLabel[] imageLabels;
    
    public ImageDeleter() {
        super("Image Deleter");
        
        // Load images
        ImageIcon[] images = new ImageIcon[3];
        images[0] = new ImageIcon("ground.png");
        images[1] = new ImageIcon("player.png");
        images[2] = new ImageIcon("icon.jpg");
        
        // Create image labels
        imageLabels = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            imageLabels[i] = new JLabel(images[i]);
            imageLabels[i].addMouseListener(this);
        }
        
        // Add image labels to content pane
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        for (int i = 0; i < 3; i++) {
            c.add(imageLabels[i]);
        }
        
        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }
    
    // MouseListener methods
    public void mouseClicked(MouseEvent e) {
        JLabel label = (JLabel)e.getComponent();
        Container c = label.getParent();
        c.remove(label);
        c.revalidate();
        //c.repaint();
    }
    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    
    public static void main(String[] args) {
        new ImageDeleter();
    }
}

