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
    private final Stack<Card> dealDeque;
    private final int HAND_SIZE = 7;
    private int numOfPlayers;
    private List<List<Card>> players;

    /**
     * The color of the {@link Card} currently on top of the {@link #discardPile}
     */
    private int currentColor;

    /**
     * Whether the next player in the game loop needs to be skipped
     */
    private boolean skip;
    private Stack<Card> discardPile;

    public GameEngine(int numOfPlayers) {
        this.dealDeque = Utils.generateCards();
        this.numOfPlayers = numOfPlayers;
        initializePlayers(numOfPlayers);
    }

    /**
     * Initializes the {@code players} field with an appropriate
     * number of players
     * @param numOfPlayers desired number of players in the game
     */
    private void initializePlayers(int numOfPlayers) {
        if (numOfPlayers < 2 || numOfPlayers > 10) {
            throw new IllegalNumberOfPlayersException(numOfPlayers);
        }
        dealCards(numOfPlayers);
    }

    /**
     * Gets called by {@link #initializePlayers(int)} method as a helper
     * method to deal the appropriate number of cards to the players
     * @param numOfPlayers desired number of players in the game
     */
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

    /**
     * The main game loop for the Uno game.
     * Before calling this method, {@link #dealDeque}, {@link #discardPile},
     * and {@link #players} fields should all be initialized before
     * entering this loop. This loop also calls all the logic required
     * to play a game of Uno.
     */
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        discardPile.push(dealDeque.pop());

        // if the last player played a skip
        skip = false;

        // todo: replace with true and check the win condition after every player plays a card
        while (!haveWinner()) {
            for (int i = 0; i < numOfPlayers; i++) {
                // check if the current player should be skipped and
                // skips the current player if is true
                if (skip) {
                    skip = false;
                    continue;
                }

                List<Card> player = players.get(i);
                int cardNum;
                while (true) {
                    // get user input to select a card
                    System.out.print("Select card: ");
                    cardNum = scanner.nextInt();
                    Card selectedCard = player.get(cardNum);

                    // validate whether card selected in valid
                    if (isValidPlay(selectedCard)) {
                        // change color if needed
                        if (selectedCard.color() != currentColor) {
                            currentColor = selectedCard.color();
                        }
                        // perform action if is an action card
                        performAction(selectedCard);

                        // break out of loop if everything went right
                        // continue looping if user choice is not valid
                        break;
                    } else {
                        System.out.println("Selected card is not valid");
                    }
                }
                // push the card being played by user into the discardPile
                discardPile.push(player.remove(cardNum));
            }
        }
    }

    /**
     * Checks if the card passed in as parameter is an action card.
     * Performs the desired action if so and does no operation if not.
     *
     * @param selectedCard {@link Card} object to pass in
     */
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

    /**
     * Check if the card passed in as parameter is a valid play
     * based on the current state of the discard pile.
     *
     * @param selectedCard {@link Card} object to pass in
     * @return {@code true} if is valid a valid play and {@code false} otherwise
     */
    private boolean isValidPlay(Card selectedCard) {
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
