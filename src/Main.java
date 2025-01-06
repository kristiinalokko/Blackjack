//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Deck deckInGame = new Deck();
        deckInGame.setNumberOfDecksInPlay(2);
        for (int i = 0; i < 52; i++) {
            System.out.println(deckInGame.getDeckInPlay().get(i));
        }





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
