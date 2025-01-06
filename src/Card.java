public class Card {

    String suit;
    String rank;
    int value;

    public Card(Suit suit, Rank rank) {
        this.suit = String.valueOf(suit);
        this.rank = String.valueOf(rank);
        this.value = getValueForRank(String.valueOf(rank));
    }

    private int getValueForRank(String rank) {
        int value = 0;
        if (rank.equals("ACE")) {value = 1;}
        if (rank.equals("TWO")) {value = 2;}
        if (rank.equals("THREE")) {value = 3;}
        if (rank.equals("FOUR")) {value = 4;}
        if (rank.equals("FIVE")) {value = 5;}
        if (rank.equals("SIX")) {value = 6;}
        if (rank.equals("SEVEN")) {value = 7;}
        if (rank.equals("EIGHT")) {value = 8;}
        if (rank.equals("NINE")) {value = 9;}
        if (rank.equals("TEN")) {value = 10;}
        if (rank.equals("JACK")) {value = 10;}
        if (rank.equals("QUEEN")) {value = 10;}
        if (rank.equals("KING")) {value = 10;}
        return value;
    }

    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }


}
