import java.awt.*;
import javax.swing.*;

public class GameTable extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom painting code goes here
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1000, 600);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Dealer", 480, 25);
        displayFaceDownCard(g, 100, 100);
    }

    public static void main(String[] args) {
        // Create a frame (window)
        JFrame frame = new JFrame("Game Table");
        frame.setSize(1000, 600);     // width, height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GameTable());
        // Make it visible
        frame.setVisible(true);
    }

    private static void displayFaceDownCard(Graphics g, int x, int y) {
        // Draw a face-down card at the specified position (x, y)
        Image cardBack = convertImage("cards\\back1.GIF");
        g.drawImage(cardBack, x, y, Color.BLUE, null); // Assuming back1.GIF is a valid image
    }
    
    private static Image convertImage(String filePath) {
        // Load the GIF as an ImageIcon
        ImageIcon icon = new ImageIcon(filePath);

        // Get the Image object from the icon
        Image image = icon.getImage();

        // Return the image for further processing or display
        return image;
    }
}
