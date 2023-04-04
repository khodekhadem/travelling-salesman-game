import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageDisplay extends JFrame {
    private BufferedImage image;

    public ImageDisplay() {
        setTitle("Image Display");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);

        try {
            image = ImageIO.read(new File("ground.png"));
            //paint2(getGraphics());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void paint(Graphics g) {
                    paint2(g,6);
                    //g.drawImage(image, 500, 500, null);
        }

        public void paint2(Graphics g,int chand) {
            for (int i = 0; i < chand; i++) {
                for (int j = 0; j < chand; j++) {
                    g.drawImage(image, i*50, j*50, null);
                }
            }
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageDisplay display = new ImageDisplay();
            display.setVisible(true);
        });
    }
}

