public class Game {
    private Dealer dealer;
    private Player player;
    private Deck deck;

    public Game(Deck deck, Dealer dealer, Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
    }

    public void startGame() {
        deck.shuffle();
        dealer.initdeal(player);
        // Add game logic here (e.g., player actions, dealer actions, etc.)
    }

    public void evalGame(int bet) {
        int playerScore = player.score();
        dealer.play(playerScore);
        int dealerScore = dealer.score();

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
