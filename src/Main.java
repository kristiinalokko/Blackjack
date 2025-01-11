import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Deck deckInGame = new Deck();

        deckInGame.setNumberOfDecksInPlay(1);
//        for (int i = 0; i < deckInGame.getDeckInPlay().length(); i++) {
//            System.out.println(deckInGame.getDeckInPlay().get(i));
//        }

        Deck.shuffle(deckInGame.getDeckInPlay());
        deckInGame = playOneRound(deckInGame);


    }

    private static Deck playOneRound(Deck deck) {

        Scanner in = new Scanner(System.in);

        int valueOfDealersHand;
        int valueOfPlayersHand;

        List<Card> dealersHand = new ArrayList<>();
        List<Card> playersHand = new ArrayList<>();

        Card nextCard = Deck.drawNewCard(deck.getDeckInPlay());
        nextCard.setFaceDown(true);
        dealersHand.add(nextCard);
        dealersHand.add(Deck.drawNewCard(deck.getDeckInPlay()));
        playersHand.add(Deck.drawNewCard(deck.getDeckInPlay()));
        playersHand.add(Deck.drawNewCard(deck.getDeckInPlay()));

        valueOfPlayersHand = totalValueOfHand(playersHand);
        valueOfDealersHand = totalValueOfHand(dealersHand);

        System.out.println("Dealer's hand: ");
        printHand(dealersHand);
        System.out.println("Dealer's hand value : " + valueOfDealersHand);
        System.out.println("Player's hand: ");
        printHand(playersHand);
        System.out.println("Player's hand value : " + valueOfPlayersHand);

        while (valueOfPlayersHand < 21) {
            System.out.println();
            System.out.println("Hit or Stand?");

            String s = in.nextLine();
            s.toLowerCase();
            if (s.equals("hit")) {
                playersHand.add(Deck.drawNewCard(deck.getDeckInPlay()));
                valueOfPlayersHand = totalValueOfHand(playersHand);
                System.out.println("Player's hand: ");
                printHand(playersHand);
                System.out.println("Player's hand value : " + valueOfPlayersHand);
            }
            if (s.equals("stand")) {
                break;
            }
        }

        for (Card card : dealersHand) {
            card.setFaceDown(false);
        }
        valueOfDealersHand = totalValueOfHand(dealersHand);
        System.out.println("Dealer's hand: ");
        printHand(dealersHand);
        System.out.println("Dealer's hand value : " + valueOfDealersHand);

        if (valueOfPlayersHand > 21) {
            System.out.println("Player busts! Dealer wins");
            return deck;
        }
        if (valueOfPlayersHand == 21 && valueOfDealersHand != 21) {
            System.out.println("Blackjack! Player wins");
            return deck;
        }
        if (valueOfPlayersHand != 21 && valueOfDealersHand == 21) {
            System.out.println("Blackjack! Dealer wins");
            return deck;
        }

        while (valueOfDealersHand < 17) {
            dealersHand.add(Deck.drawNewCard(deck.getDeckInPlay()));
            valueOfDealersHand = totalValueOfHand(dealersHand);
            System.out.println(" Dealer hits. Dealer's hand: ");
            printHand(dealersHand);
            System.out.println("Dealer's hand value : " + valueOfDealersHand);
        }

        if (valueOfDealersHand > 21) {
            System.out.println("Dealer busts! Player wins");}
        else if (valueOfDealersHand > valueOfPlayersHand) {
            System.out.println("Dealer wins");
        } else if (valueOfPlayersHand > valueOfDealersHand) {
            System.out.println("Player wins");
        } else {
            System.out.println("wtf");
        }

        return deck;
    }

    private static void printHand(List<Card> hand) {
        for (Card card : hand) {
            if (card.isFaceDown()) {
                System.out.println("*** of ***");
            } else {
                System.out.println(card.toString());
            }
        }
    }

    private static int totalValueOfHand(List<Card> playersHand) {
        int value = 0;

        for (Card card : playersHand) {
            if (!card.isFaceDown()) {
                value += card.getValue();
            }
        }

        return value;
    }


}

/* TO DO:
 - Card:
    rank
    suit (Clubs, hearts, diamonds, spades)
    value
    status (enum?lists? deck/hand/down default:deck)
 - Deck
    createNewDeck(nrOfDecks)                ?? return list? array? treeset?
    shuffle()
 - Player
    list(Card)
    valueOfHand
    bankBalance?
 - Dealer
    list(Card)
    valueOfHand


 - Main for the main logic:
    Deck.createNewDeck()

    while there's enough in bankBalance?:
    playOneRound()
        setTable()
        add two cards to dealer's hand (one !faceUp)
            dealer's hand valueOfHand sum (if !faceUp, not added)
        add two cards to player's hand
            player's hand valueOfHand sum
        while both hand valueOfHand <21
            Hit or Stand?
            Hit ---> add card to player & continue
            Stand ---> dealer turnCardFaceUp, then draws (random) until valueOfHand>=17
        if either hand valueOfHand == 21
            21 wins!
        if wither hand valueOfHand >21
            the other wins!

    Deck.shuffle(all Cards status==down ->> status=deck)


TO DO vol2:
- LOGIC OF THE GAME (ONE ROUND). Build cards, deck, player & dealer.
Write the logic of the game, printing the cards after each turn to console.
Declare winner of the round in the console.
- ADD THE ACE VALUE IS EITHER 1 OR 11 ASPECT

- ADD THE GAMBLING ASPECT. Add rounds, keep track of the deck, keep track of player's bank, place bets.

- VISUALS/FRONTEND. Create a REST API? JavaFX?
Add card images, deck (maybe separate images for aLotOfCards, fewCardsLeft)
Buttons for Start/Place bet, Hit/Stand etc.
Add background music?
+ visual effects if you lose

- ADD BASIC STRATEGY SUGGESTIONS
Pop up window? or a separate corner "see basic strategy suggestions"

- CREATE THE USER DATABASE. User logs in, the bank balance should be in a database maybe?
A sql database for user/password/bank balance?

-

-








 */
