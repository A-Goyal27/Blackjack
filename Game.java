public class Game {
    public Dealer dealer;
    public Player player;
    public Deck deck;

    public Game(Deck deck, Dealer dealer, Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
    }

    public void startGame() {
        deck.shuffle();
        dealer.initdeal(player);
       
        
    }

    public int evalGame(int bet) { //returns true if player wins
        //get scores and have the dealer play
        int playerScore = player.score();
        dealer.play(playerScore);
        int dealerScore = dealer.score();

        
        //detemine winner
        if (playerScore > 21) {
            System.out.println("Player busts! Dealer wins.");
            player.payout(-bet);
            return -1;
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("Player wins!");
            player.payout(bet);
            return 1;
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins!");
            player.payout(-bet);
            return -1;
        } else {
            System.out.println("It's a tie!");
            return 0;
        }
        
    }

}
