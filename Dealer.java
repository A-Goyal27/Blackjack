import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand = new ArrayList<>();
    private Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
    }

    public void addCard(Card card) {
        hand.add(card);
    }
    public void clearHand() {
        hand.clear();
    }
    public int score() {
        int total = 0;
        int aces = 0;

        for (Card card : hand) {
            total += card.getValue();
            if (card.getValue() == 11) { // Assuming Ace is represented as 11
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10; // Adjust for Ace being counted as 1 instead of 11
            aces--;
        }

        return total;
    }
    public void deal(Player player) {
        player.addCard(deck.dealCard());
        this.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        this.addCard(deck.dealCard());
    }
    


}
