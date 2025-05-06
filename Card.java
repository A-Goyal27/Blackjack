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

    // Method to return a string representation of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}