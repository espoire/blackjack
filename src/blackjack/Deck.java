package blackjack;

public class Deck {
    private Card[] cards;
    private int cardsDealt = 0;

    public Deck() {
        this.cards = new Card[Card.VALUES.length * Card.SUITS.length]; // 52

        for(int i = 0; i < Card.SUITS.length; i++) {
            for(int j = 0; j < Card.VALUES.length; j++) {
                String value = Card.VALUES[j];
                String suit  = Card.SUITS[i];
                int deckPosition = i * Card.VALUES.length + j;

                this.cards[deckPosition] = new Card(value, suit);
            }
        }
    }

    public Deck(Card[] cards) {
        this.cards = cards;
    }

    public void shuffle() {
        this.cardsDealt = 0;
        this.shuffleUndealtCards();
    }

    public void shuffleUndealtCards() {
        for(int i = this.cardsDealt; i < this.cards.length; i++) {
            int randomPosition = Random.random(i, this.cards.length - 1);

            // Swap the cards at positions i and randomPosition.
            Card temp = this.cards[i];
            this.cards[i] = this.cards[randomPosition];
            this.cards[randomPosition] = temp;
        }
    }

    public Card dealCard() {
        if(this.cardsDealt >= this.cards.length) return null;

        Card card = this.cards[this.cardsDealt];
        this.cardsDealt++;

        return card;
    }

    public int size() {
        return this.cards.length - this.cardsDealt;
    }

    public boolean isEmpty() {
        return this.size() <= 0;
    }
}
