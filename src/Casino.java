import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Casino {
    public Card aceOfHearts;
    public Card[] deck;
    public Player jai;
    public Player dealer;

    public int hand = 3;
    public int deck2 = 4;


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
        System.out.println("test");
        dealerMoves();
        checkWinner();
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

    // source: https://www.theserverside.com/tutorial/How-Javas-Systemin-reads-input-from-the-user#:~:text=What%20is%20System.in%3F,constructor%20of%20the%20Scanner%20class
    public void ask() {
        String ask = "hit";

        while(ask.equals("hit")) {
            System.out.println("Would you like to hit or stand?");

            Scanner scanner = new Scanner(System.in);

            ask = scanner.nextLine();
            System.out.println("You decided to " + ask);

            Card[] newArray = new Card[jai.hand.length+1];
            for(int i = 0; i < newArray.length - 1; i++) {
                newArray[i] = jai.hand[i];
            }
            newArray[newArray.length-1] = deck[deck2];

            jai.hand = newArray;

            hand++;
            deck2++;

            jai.cardsSum += deck[deck2].value;
            jai.print();
        }

        if(ask.equals("stand")) {
// change length of hand for each of these
            System.out.println("You decided to " + ask);
            jai.print();
        } else {
            System.out.println("You did not say 'hit' or 'stand'.");
        }
    }

    public void dealerMoves() {
        if(dealer.cardsSum < 18) {
            Card[] dealerArray = new Card[dealer.hand.length+1];
            for(int i = 0; i < dealerArray.length - 1; i++) {
                dealerArray[i] = dealer.hand[i];
            }
            dealerArray[dealerArray.length-1] = deck[deck2];

            dealer.hand = dealerArray;

            hand++;
            deck2++;

            dealer.cardsSum += dealer.hand[dealer.hand.length-1].value;

            dealer.print();
        }
    }

    public void checkWinner() {
        if(jai.cardsSum < 21 && dealer.cardsSum < 21) {
            if(jai.cardsSum > dealer.cardsSum) {
                System.out.println("You win!");
            } else if(jai.cardsSum < dealer.cardsSum) {
                System.out.println("You lose :(");
            }
        }
        if(jai.cardsSum > 21 && dealer.cardsSum > 21) {
            System.out.println("You tied with the dealer!");
        }
        if((dealer.cardsSum < 21 || jai.cardsSum < 21) && jai.cardsSum > 21) {
            System.out.println("You lose :(");
        }
        if(dealer.cardsSum > 21 && (jai.cardsSum < 21 || jai.cardsSum < 21)) {
            System.out.println("You win!");
        }
        if(dealer.cardsSum == 21 && jai.cardsSum != 21) {
            System.out.println("You lose :(");
        }
        if(dealer.cardsSum == 21 && jai.cardsSum == 21) {
            System.out.println("You win!");
        }
        if(dealer.cardsSum == jai.cardsSum) {
            System.out.println("You tied with the dealer!");
        }
    }
}