import exceptions.IllegalNumberOfPlayersException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


@Getter
@Setter
public class GameEngine {
    // FIELDS
    // deque of cards to deal from (deal deque)
    private final Stack<Card> dealDeque;
    private final int HAND_SIZE = 7;
    // each player has a hand of cards (more like a list)
    private int numOfPlayers;
    private List<List<Card>> players;
    // current color on the top of the discardPile
    private int currentColor;
    private boolean skip;
    // the discard pile
    private Stack<Card> discardPile; // initialize capacity to 108

    public GameEngine(int numOfPlayers) {
        this.dealDeque = Utils.generateCards();
        this.numOfPlayers = numOfPlayers;
        initializePlayers(numOfPlayers);
    }

    // METHODS
    // determine number of players
    private void initializePlayers(int numOfPlayers) {
        if (numOfPlayers < 2 || numOfPlayers > 10) {
            throw new IllegalNumberOfPlayersException(numOfPlayers);
        }
        dealCards(numOfPlayers);
    }

    private void dealCards(int numOfPlayers) {
        System.out.println("Deal cards to ");
        players = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            players.add(new ArrayList<>());
            for (int j = 0; j < HAND_SIZE; j++) {
                players.get(i).add(dealDeque.pop());
            }
        }
    }
    // play loop (use while true loop with index)
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        discardPile.push(dealDeque.pop());

        // if the last player played a skip
        skip = false;

        // todo: replace with true and check the win condition after every player plays a card
        while (!haveWinner()) {
            for (int i = 0; i < numOfPlayers; i++) {
                // check if the current player should be skipped
                if (skip) {
                    skip = false;
                    continue;
                }

                List<Card> player = players.get(i);
                int cardNum;
                while (true) {
                    System.out.print("Select card: ");
                    cardNum = scanner.nextInt();
                    Card selectedCard = player.get(cardNum);
                    if (isValid(selectedCard)) {
                        if (selectedCard.color() != currentColor) {
                            currentColor = selectedCard.color();
                        }
                        performAction(selectedCard);
                        break;
                    } else {
                        System.out.println("Selected card is not valid");
                    }
                }
                discardPile.push(player.remove(cardNum));
            }
        }
    }

    private void performAction(Card selectedCard) {
        switch (selectedCard.value()) {
            // skip card
            case 10 -> skip = true;
            // reverse card
            case 11 -> {

            }
            // draw two card
            // wild card
            // draw four card
        }
    }

    private boolean isValid(Card selectedCard) {
        Card topCard = discardPile.peek();
        if (selectedCard.color() == 4) {
            return true;
        } else if (selectedCard.color() == topCard.color()) {
            return true;
        } else if (selectedCard.value() == topCard.value()) {
            return true;
        }
        return false;

    }

    // reverse loop (reverse card)
    // skip a player
    // draw cards (for both when not having a card to put down or penalty)
    // merging the discard pile into deal deque
    // win condition checker
    private boolean haveWinner() {
        for (int i = 0; i < numOfPlayers; i++) {
            if (players.get(i).isEmpty()) return true;
        }
        return false;
    }
}
