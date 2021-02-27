package blackjack;

public class Card {
    public static final String[] VALUES = new String[] {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };
    public static final String[] SUITS = new String[] {
            "♥", "♦", "♣", "♠"   // Emojis
    };

    public final String value;
    public final String suit;

    public Card(String value, String suit) {
        Card.checkAllowedValue(value);
        Card.checkAllowedSuit(suit);

        this.value = value;
        this.suit = suit;
    }

    private static void checkAllowedValue(String value) {
        boolean allowed = Card.checkArrayContains(VALUES, value);

        if(!allowed) {
            throw new IllegalArgumentException("A Card cannot have a value of '" + value + "'.");
        }
    }

    private static void checkAllowedSuit(String suit) {
        boolean allowed = Card.checkArrayContains(SUITS, suit);

        if(!allowed) {
            throw new IllegalArgumentException("A Card cannot have a suit of '" + suit + "'.");
        }
    }

    private static boolean checkArrayContains(String[] array, String target) {
        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(target)) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        return this.value + this.suit;
    }
}
