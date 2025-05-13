import java.util.ArrayList;

public class Player implements Person {
    private ArrayList<Card> hand = new ArrayList<>();
    private int money;

    public Player(int initialMoney) {
        this.money = initialMoney;
    }
    
    public void addCard(Card card) {
        hand.add(card);
    }
    
    public void clearHand() {
        hand.clear();
    }

    public ArrayList<Card> getHand() {
        return hand;
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
    public int getMoney() {
        return money;
    }
    public void payout(int amount) {
        money += amount;
    }

    //public void hit()
    //public void stand()
    //public void bet()

}
