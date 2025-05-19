import java.awt.*;
import java.util.ArrayList;


import javax.swing.*;

public class GameTable extends JPanel {

    private static Deck deck = new Deck();
    private static Dealer dealer = new Dealer(deck);
    private static Player player = new Player(100);
    private static Game game = new Game(deck, dealer, player);
    private static boolean stood = false;
    private static int winner = 0; // 1 for player, -1 for dealer, 0 for tie
    private static int bet = 5;
    private static boolean canBet = true;
    

    @Override //the graphics
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom painting code goes here
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 1000, 600);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        
        //display the back of the card
        displayCard(g, 100, 100, convertImage("Blackjack\\cards\\back1.GIF"));

        //stand graphics
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Player's Hand: " + player.score(), 430, 525);
        g.drawString("Player's Money: " + player.getMoney(), 800, 50);
        if (stood) {
            displayCard(g, 470, 100, dealer.getHand().get(0).getImage());
            g.setColor(Color.WHITE);
            g.drawString("Dealer's Hand: " + dealer.score(), 430, 50);
            if (winner == 1) {
                g.drawString("Player wins!", 430, 300);
            } else if (winner == -1) {
                g.drawString("Dealer wins!", 430, 300);
            } else {
                g.drawString("It's a tie!", 430, 300);
            }
            
        }
        
        //display hands
        displayDealerHand(g, dealer);
        displayPlayerHand(g, player);

        //display bet
        g.setColor(Color.WHITE);
        g.drawString("Current Bet: " + bet, 820, 400);
        

        //end game
        if (player.getMoney() <= 0) {
            g.drawString("Game Over! You are out of money.", 430, 330);
        }

        

        
    }

    public static void main(String[] args) {
        
        
        // Create a frame (window)
        JFrame frame = new JFrame("Game Table");

        //buttons
        JButton reset = new JButton("Reset");
        reset.setBounds(850, 100, 75, 25);
        frame.add(reset);
        reset.addActionListener(e -> {
            if (stood == true){
                resetGame(frame);
                dealer.initdeal(player);
                frame.repaint();
            }
            
        });
        JButton hit = new JButton("Hit");
        hit.setBounds(850, 125, 75, 25);
        frame.add(hit);
        hit.addActionListener(e -> {
            if (stood == false){
                canBet = false;
                hit(frame);
            }
        });
        JButton stand = new JButton("Stand");
        stand.setBounds(850, 150, 75, 25);
        frame.add(stand);
        stand.addActionListener(e -> {
            if (stood == false)
                stand(frame);
        });

        //betting buttons 1, 5, 10
        JButton bet1 = new JButton("Bet 1");
        bet1.setBounds(850, 425, 75, 25);
        frame.add(bet1);
        bet1.addActionListener(e -> {
            if (player.getMoney() >= 1 && canBet) {
                bet += 1;
                if (bet > 25) {
                    System.out.println("Bet is too high. Please lower your bet.");
                    bet = 25;
                }
                frame.repaint();
            } else {
                System.out.println("Not enough money to place this bet.");
            }
        });
        JButton bet5 = new JButton("Bet 5");
        bet5.setBounds(850, 450, 75, 25);
        frame.add(bet5);
        bet5.addActionListener(e -> {
            if (player.getMoney() >= 5 && canBet) {
                bet += 5;
                if (bet > 25) {
                    System.out.println("Bet is too high. Please lower your bet.");
                    bet = 25;
                }
                frame.repaint();
            } else {
                System.out.println("Can't bet that much or you have already hit.");
            }
        });
        JButton bet10 = new JButton("Bet 10");
        bet10.setBounds(850, 475, 75, 25);
        frame.add(bet10);
        bet10.addActionListener(e -> {
            if (player.getMoney() >= 10 && canBet) {
                bet += 10;
                if (bet > 25) {
                    System.out.println("Can't bet that much or you have already hit.");
                    bet = 25;
                }
                frame.repaint();
            } else {
                System.out.println("Can't bet that much or you have already hit.");
            }
        });
        

        frame.setSize(1000, 600);     // width, height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GameTable());
        
        // Make it visible
        frame.setVisible(true);

        runGame(frame);
       

        
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

    private static void runGame(JFrame frame) {
        // Initialize the game components
        System.out.println("Game started. Player's initial money: " + player.getMoney());
        game.startGame();
        frame.repaint();
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
        if (!stood)
            displayCard(g, 470, 100, convertImage("Blackjack\\cards\\back1.GIF")); //display the face down dealer card
        g.setColor(Color.WHITE);
        g.drawString("Dealer", 480, 25);
        for (int i = 1; i < dealerHand.size(); i++) {
            displayCard(g, 470 + (i * 30), 100, dealerHand.get(i).getImage());
            
        }
    
    }

    private static void hit(JFrame frame) {
        // Implement hit logic
        player.addCard(deck.dealCard());
        frame.repaint();
    }

    private static void stand(JFrame frame) {
        // Implement stand logic
        //show face down card
        winner = game.evalGame(bet); // Example bet amount
        stood = true;
        frame.repaint();
        
        
    }

    private static void resetGame(JFrame frame) {
        // Reset the game state
        dealer.clearHand();
        player.clearHand();

        bet = 5;
        canBet = true;
        stood = false;
        //frame.repaint();
    }

    
}
