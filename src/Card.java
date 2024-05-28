public class Card {
    public String suit;
    public int value;
    public String name;

    public Card(int pName, int pSuit) {
        // name = pName;
        // suit = pSuit;
        if (pName == 0) {
            value = 11;
            name = "Ace";
        } else if (pName == 1) {
            value = 2;
            name = "Two";
        } else if (pName == 2) {
            value = 3;
            name = "Three";
        } else if (pName == 3) {
            value = 4;
            name = "Four";
        } else if (pName == 4) {
            value = 5;
            name = "Five";
        } else if (pName == 5) {
            value = 6;
            name = "Six";
        } else if (pName == 6) {
            value = 7;
            name = "Seven";
        } else if (pName == 7) {
            value = 8;
            name = "Eight";
        } else if (pName == 8) {
            value = 9;
            name = "Nine";
        } else if (pName == 9) {
            value = 10;
            name = "Ten";
        } else if (pName == 10) {
            value = 11;
            name = "Jack";
        } else if (pName == 11) {
            value = 10;
            name = "Queen";
        } else if (pName == 12) {
            value = 10;
            name = "King";
        }

        if (pSuit == 0) {
            suit = "Hearts";
        } else if (pSuit == 1) {
            suit = "Diamonds";
        } else if (pSuit == 2) {
            suit = "Clubs";
        } else if (pSuit == 3) {
            suit = "Spades";
        }
    }
    public void print() {
        System.out.println("the " + name + " of " + suit + " is worth " + value + " points.");
    }
}