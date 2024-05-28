public class Player {
    public boolean isDealer;
    public int cardsSum;
    public boolean isBust;
    public Card[] hand;

    public Player(boolean pIsDealer, int pCardsSum, boolean pIsBust) {
        isDealer = pIsDealer;
        cardsSum = pCardsSum;
        isBust = pIsBust;
        hand = new Card[2];

        // int pCardsSum = Card.value();
    }

    public void print() {
        if(isDealer) {
            System.out.println("The dealer has " + cardsSum + " points.");
        } else {
            System.out.println("The player has " + cardsSum + " points.");
        }

        // TODO: print the hand
        for(int i = 0; i < hand.length; i++) {
            hand[i].print();
        }
    }
}
