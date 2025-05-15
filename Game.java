public class Game {
    public Dealer dealer;
    public Player player;
    public Deck deck;

    public Game(Deck deck, Dealer dealer, Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
    }

    public boolean startGame() {
        deck.shuffle();
        dealer.initdeal(player);
        return true;
        
    }

    public void evalGame(int bet) {
        //get scores and have the dealer play
        int playerScore = player.score();
        dealer.play(playerScore);
        int dealerScore = dealer.score();
        
        //detemine winner
        if (playerScore > 21) {
            System.out.println("Player busts! Dealer wins.");
            player.payout(-bet);
            player.clearHand();
            dealer.clearHand();
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("Player wins!");
            player.payout(bet);
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins!");
            player.payout(-bet);
        } else {
            System.out.println("It's a tie!");
        }
    }

}
