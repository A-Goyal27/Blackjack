import java.awt.*;
import javax.swing.*;

//test
//test 2

public class Card {
    private String suit; // The suit of the card (e.g., "Hearts", "Diamonds", "Clubs", "Spades")
    private String rank; // The rank of the card (e.g., "2", "3", ..., "10", "Jack", "Queen", "King", "Ace")

    // Constructor to create a card with a specific suit and rank
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getter for the suit
    public String getSuit() {
        return suit;
    }

    // Getter for the rank
    public String getRank() {
        return rank;
    }

    public int getValue() {
        // Convert the rank to a numerical value for scoring
        switch (rank) {
            case "Jack":
            case "Queen":
            case "King":
                return 10; // Face cards are worth 10
            case "Ace":
                return 11; // Ace is worth 11 (should also be worth 1 but I can add that later)
            default:
                return Integer.parseInt(rank); // Convert numeric ranks to integers
        }
    }

    // Method to return a string representation of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public Image getImage() {
        // Load the image for the card based on its suit and rank
        String filePath = rank.toLowerCase() + suit.toLowerCase() + ".GIF"; // Assuming images are named like ex. 2Hearts.GIF
        ImageIcon icon = new ImageIcon(filePath);
        return icon.getImage(); // Return the image object
    }
}