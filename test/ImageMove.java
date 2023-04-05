import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageMove extends JFrame implements KeyListener {
    private BufferedImage image;
    private int x, y;

    public ImageMove() {
        setTitle("Image Move");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setFocusable(true);
        addKeyListener(this);

        try {
            image = ImageIO.read(new File("ground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 0;
        y = 0;
    }

    public void paint(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            x -= 10;
        } else if (key == KeyEvent.VK_RIGHT) {
            x += 10;
        } else if (key == KeyEvent.VK_UP) {
            y -= 10;
        } else if (key == KeyEvent.VK_DOWN) {
            y += 10;
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageMove move = new ImageMove();
            move.setVisible(true);
        });
    }
}

