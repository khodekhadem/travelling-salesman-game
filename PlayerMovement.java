import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerMovement extends JFrame implements KeyListener {
    private ImageIcon playerImage;
    private JLabel playerLabel;
    private ImageIcon castleImage;
    private JLabel castleLabel;

    //private ImageIcon wallImage;
    private JLabel[] wallLabels;

    private JLabel[] imageLabels;
    private int playerX, playerY;
    private int abad;
    
    public PlayerMovement(int abad) {
        super("Player Movement");
         this.abad = abad ;
        // // Load player images
         ImageIcon[] walls = new ImageIcon[5];
         for (int i = 0; i < 5; i++) {
             walls[i] = new ImageIcon("wall.png");
         }
        
         wallLabels = new JLabel[5];
         for (int i = 0; i < 5; i++) {
             wallLabels[i] = new JLabel(walls[i]);
             //imageLabels[i].addMouseListener(this);
         }
         for (int i = 0; i < 5; i++) {
                 wallLabels[i].setBounds(i*50,50,50,50);
         }
        InsertGrounds(abad);


        playerImage = new ImageIcon("player.png");
        
        // Create player label
        playerX = 0;
        playerY = 0;
        playerLabel = new JLabel(playerImage);
        playerLabel.setBounds(playerX, playerY, playerImage.getIconWidth(), playerImage.getIconHeight());

        //add castle image
        castleImage = new ImageIcon("castle.jpg");
        castleLabel = new JLabel(castleImage);
        castleLabel.setBounds((abad/2)*50, (abad/2)*50, 50,50);
        
        // Add player label to content pane
        Container c = getContentPane();
        c.setLayout(null);
        c.add(playerLabel);
        c.add(castleLabel);
        
        for (int i = 0; i < 5; i++) {
            c.add(wallLabels[i]);
        }
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
    void InsertGrounds(int tmpabad){

        ImageIcon[] images = new ImageIcon[tmpabad*tmpabad];
        for (int i = 0; i < tmpabad*tmpabad; i++) {
            images[i] = new ImageIcon("ground.png");
        }

        imageLabels = new JLabel[tmpabad*tmpabad];
        for (int i = 0; i < tmpabad*tmpabad; i++) {
            imageLabels[i] = new JLabel(images[i]);
            //imageLabels[i].addMouseListener(this);
        }
        for (int i = 0; i < tmpabad; i++) {
            for (int j = 0; j < tmpabad; j++) {
                    
                imageLabels[(i*tmpabad) + j].setBounds(i*50,j*50,50,50);
            }
        }

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

