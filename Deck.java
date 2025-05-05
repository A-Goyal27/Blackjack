public class Deck {
    private Card[] cards; // Array to hold the cards in the deck
    private int topCardIndex; // Index of the top card in the deck

    // Constructor to create a standard 52-card deck
    public Deck() {
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        cards = new Card[52]; // Initialize the array for 52 cards
        topCardIndex = 0; // Start with an empty deck

        // Populate the deck with cards
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                cards[topCardIndex++] = new Card(suits[i], ranks[j]);
            }
        }
    }

    // Method to shuffle the deck
    public void shuffle() {
        for (int i = cards.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1)); // Random index from 0 to i
            Card temp = cards[i]; // Swap cards[i] and cards[j]
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    // Method to deal a card from the top of the deck
    public Card dealCard() {
        if (topCardIndex == 0) {
            return null; // No more cards to deal
        }
        return cards[--topCardIndex]; // Return the top card and decrement the index
    }

    // Method to get the number of remaining cards in the deck
    public int getRemainingCards() {
        return topCardIndex;
    }
}
