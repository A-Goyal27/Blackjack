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
    
}
