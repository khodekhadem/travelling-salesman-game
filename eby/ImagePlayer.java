import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePlayer extends JFrame implements KeyListener {
    private BufferedImage image;
    private BufferedImage player;
    private int x, y;
    private int dx, dy;
    private boolean left, right, up, down;

    public ImagePlayer() {
        setTitle("Image Player");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setFocusable(true);
        addKeyListener(this);

        try {
            image = ImageIO.read(new File("ground.png"));
            player= ImageIO.read(new File("player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 0;
        y = 0;
        dx = 0;
        dy = 0;

        Timer timer = new Timer(10, (e) -> {
            x += dx;
            y += dy;
            repaint();
        });
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        paint2(g,7);
        g.drawImage(player, x, y, null);
    }
    
    public void paint2(Graphics g,int chand) {
        for (int i = 0; i < chand; i++) {
            for (int j = 0; j < chand; j++) {
                g.drawImage(image, i*50, j*50, null);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -50;
            left = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 50;
            right = true;
        } else if (key == KeyEvent.VK_UP) {
            dy = -50;
            up = true;
        } else if (key == KeyEvent.VK_DOWN) {
            dy = 50;
            down = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            left = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            right = false;
        } else if (key == KeyEvent.VK_UP) {
            up = false;
        } else if (key == KeyEvent.VK_DOWN) {
            down = false;
        }

        if (!left && !right) {
            dx = 0;
        }

        if (!up && !down) {
            dy = 0;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImagePlayer player = new ImagePlayer();
            player.setVisible(true);
        });
    }
}

