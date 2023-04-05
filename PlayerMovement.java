import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerMovement extends JFrame implements KeyListener {
    private ImageIcon playerImage;
    private JLabel playerLabel;
    private JLabel[] imageLabels;
    private int playerX, playerY;
    private int abad;
    
    public PlayerMovement(int abad) {
        super("Player Movement");
        this.abad = abad ;
        // Load player image
        ImageIcon[] images = new ImageIcon[abad*abad];
        for (int i = 0; i < abad*abad; i++) {
            images[i] = new ImageIcon("ground.png");
        }

        imageLabels = new JLabel[abad*abad];
        for (int i = 0; i < abad*abad; i++) {
            imageLabels[i] = new JLabel(images[i]);
            //imageLabels[i].addMouseListener(this);
        }
        for (int i = 0; i < abad; i++) {
            for (int j = 0; j < abad; j++) {
                    
                imageLabels[(i*abad) + j].setBounds(i*50,j*50,50,50);
            }
        }
        playerImage = new ImageIcon("player.png");
        
        // Create player label
        playerX = 0;
        playerY = 0;
        playerLabel = new JLabel(playerImage);
        playerLabel.setBounds(playerX, playerY, playerImage.getIconWidth(), playerImage.getIconHeight());
        
        // Add player label to content pane
        Container c = getContentPane();
        c.setLayout(null);
        c.add(playerLabel);
        
        //c.setLayout(null);
        for (int i = 0; i < abad*abad; i++) {
            c.add(imageLabels[i]);
        }
        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
        
        // Add key listener
        addKeyListener(this);
    }
    
    // KeyListener methods
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                if(playerY> 0){
                    playerY -= 50;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(playerY< (abad-1)*50){
                    playerY += 50;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(playerX> 0){
                    playerX -= 50;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(playerX< (abad-1)*50){
                    playerX += 50;
                }
                break;
        }
        playerLabel.setBounds(playerX, playerY, playerImage.getIconWidth(), playerImage.getIconHeight());
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    
   // public static void main(String[] args) {
   //     new PlayerMovement();
   // }
}

