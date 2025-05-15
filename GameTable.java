import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class GameTable extends JPanel {

    private static Deck deck = new Deck();
    private static Dealer dealer = new Dealer(deck);
    private static Player player = new Player(100);
    private static boolean tick = false;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom painting code goes here
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1000, 600);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        
        //display the back of the card
        displayCard(g, 100, 100, convertImage("Blackjack\\cards\\back1.GIF"));
        
        if (tick) {
            displayDealerHand(g, dealer);
            displayPlayerHand(g, player);
        }

        
    }

    public static void main(String[] args) {
        
        // Create a frame (window)
        JFrame frame = new JFrame("Game Table");
        frame.setSize(1000, 600);     // width, height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GameTable());
        // Make it visible
        frame.setVisible(true);

        runGame(deck, dealer, player);
       
        
        if (tick) {
            System.out.println("Game started. Player's initial money: " + player.getMoney());
            // Repaint the panel to update the game state
            frame.repaint();
        }
        
    }

    private static void displayCard(Graphics g, int x, int y, Image cardImage) {
        // Draw the card image at the specified coordinates
        g.drawImage(cardImage, x, y, Color.BLUE, null); // Assuming back1.GIF is a valid image
    }
    
    private static Image convertImage(String filePath) {
        // Load the GIF as an ImageIcon
        ImageIcon icon = new ImageIcon(filePath);

        // Get the Image object from the icon
        Image image = icon.getImage();

        // Return the image for further processing or display
        return image;
    }

    private static void runGame(Deck deck, Dealer dealer, Player player) {
        // Initialize the game components
        Game game = new Game(deck, dealer, player);
        tick = game.startGame();
        // Add game loop or event handling here
        
    }

    private static void displayPlayerHand(Graphics g, Player player) {
        ArrayList<Card> playerHand = player.getHand();
        // Display the player's hand
        g.setColor(Color.WHITE);
        g.drawString("Player", 480, 550);
        for (int i = 0; i < playerHand.size(); i++) {
            displayCard(g, 470 + (i * 30), 400, playerHand.get(i).getImage());
        }
    }

    private static void displayDealerHand(Graphics g, Dealer dealer) {
        ArrayList<Card> dealerHand = dealer.getHand();
        
        // Display the dealer's hand
        displayCard(g, 470, 100, convertImage("Blackjack\\cards\\back1.GIF")); //display the face down dealer card
        g.setColor(Color.WHITE);
        g.drawString("Dealer", 480, 25);
        for (int i = 1; i < dealerHand.size(); i++) {
            displayCard(g, 470 + (i * 30), 100, dealerHand.get(i).getImage());
            System.out.println("Showing  card");
        }
    
    }
}
