import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    int numberOfDecksInPlay = 1;

    public List<Card> deckInPlay = createTheDeckInPlay(numberOfDecksInPlay);

    private List<Card> createTheDeckInPlay(int numberOfDecksInPlay) {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < numberOfDecksInPlay; i++) {
            deck.addAll(createNew52Deck());
        }
        return deck;
    }


    public static List<Card> createNew52Deck() {
        List<Card> deck = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    public void shuffle() {
        Collections.shuffle(deckInPlay);
    }

    public Card drawNewCard() {
        if (deckInPlay.isEmpty()) {
            throw new IllegalStateException("The deck is empty.");
        }
        return deckInPlay.removeLast();
    }

    public List<Card> getDeckInPlay() {
        return deckInPlay;
    }

    public void setDeckInPlay(List<Card> deckInPlay) {
        this.deckInPlay = deckInPlay;
    }

    public int getNumberOfDecksInPlay() {
        return numberOfDecksInPlay;
    }

    public void setNumberOfDecksInPlay(int numberOfDecksInPlay) {
        this.numberOfDecksInPlay = numberOfDecksInPlay;
    }
}
