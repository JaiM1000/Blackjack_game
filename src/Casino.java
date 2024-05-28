import java.awt.event.KeyEvent;

public class Casino {
    public Card aceOfHearts;
    public Card[] deck;
    public Player jai;
    public Player dealer;

    public static void main (String[] args) {
        Casino x = new Casino();
    }
    public Casino() {
        System.out.println("Welcome to Jai's Casino!");
        deck = new Card[52];
        int door = 0;
        for(int j = 0; j < 4; j++){
            for(int i = 0; i < 13; i++) {
                aceOfHearts = new Card(i, j);
                //System.out.println(aceOfHearts);
                //aceOfHearts.print();
                deck[door] = aceOfHearts;
                door++;

            }
        }
        shuffle();
        printDeck();

        jai = new Player(false, 0, false);

        dealer = new Player(true, 0, false);
        deal();
        jai.print();
        dealer.print();
        ask();
    }

    public void deal() {
        // give the player the first and second cards in the deck
        jai.hand[0] = deck[0];
        jai.hand[1] = deck[1];
        jai.cardsSum = jai.hand[1].value + jai.hand[0].value;

        dealer.hand[0] = deck[2];
        dealer.hand[1] = deck[3];
        dealer.cardsSum = dealer.hand[1].value + dealer.hand[0].value;
    }
    public void printDeck() {
        for(int i = 0; i < deck.length; i++) {
            deck[i].print();
        }
    }

    public void shuffle() {
        // need a loop to go through all cards
        // put cards random index in index i
        for(int i = 0; i < deck.length; i++) {
            int esme = (int) (Math.random() * 52);

            Card temp = deck[i];
            deck[i] = deck[esme];
            deck[esme] = temp;
        }
    }

    public void ask() {
        int dealerIndex = 2;
        int deckIndex = 4;

        int playerIndex = 2;
        int deckIndex2 = 15;

        if(dealer.hand.cardsSum < 18) {
            dealer.hand[dealerIndex] = deck[deckIndex];
            dealerIndex++;
            deckIndex++;
        }
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode == 'h') {
                jai.hand.[playerIndex] = deck[deckIndex2];
            }
            // if(e.getKeyCode == 's') {

            // }
            playerIndex++;
            deckIndex2++;
        }
    }
}