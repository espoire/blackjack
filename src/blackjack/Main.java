package blackjack;

public class Main {

    public static void main(String[] args) {
	    Deck ofCards = new Deck();

	    while(!ofCards.isEmpty()) {
	        System.out.println(ofCards.dealCard());
        }
    }
}
