import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MapGame extends JFrame implements KeyListener {
    private JLabel mapLabel, playerLabel;
    private ImageIcon mapImage, playerImage;
    private int playerX, playerY;
    
    public MapGame() {
        super("Map Game");
        
        // Load images
        mapImage = new ImageIcon("javaicom.png");
        playerImage = new ImageIcon("player.png");
        
        // Create labels
        mapLabel = new JLabel(mapImage);
        playerX = mapImage.getIconWidth() / 2 - playerImage.getIconWidth() / 2;
        playerY = mapImage.getIconHeight() / 2 - playerImage.getIconHeight() / 2;
        playerLabel = new JLabel(playerImage);
        playerLabel.setBounds(playerX, playerY, playerImage.getIconWidth(), playerImage.getIconHeight());
        
        // Add labels to content pane
        Container c = getContentPane();
        c.setLayout(null);
        c.add(mapLabel);
        c.add(playerLabel);
        
        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(mapImage.getIconWidth(), mapImage.getIconHeight());
        setVisible(true);
        
        // Add key listener
        addKeyListener(this);
    }
    
    // KeyListener methods
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                playerY -= 10;
                break;
            case KeyEvent.VK_DOWN:
                playerY += 10;
                break;
            case KeyEvent.VK_LEFT:
                playerX -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                playerX += 10;
                break;
        }
        playerLabel.setBounds(playerX, playerY, playerImage.getIconWidth(), playerImage.getIconHeight());
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    
    public static void main(String[] args) {
        new MapGame();
    }
}

