package exceptions;

public class IllegalNumberOfPlayersException extends RuntimeException{
    public IllegalNumberOfPlayersException(int illegalNumberOfPlayers) {
        super(illegalNumberOfPlayers < 2 ? "Min players: 2, Input: " + illegalNumberOfPlayers : "Max players: 10, Input: " + illegalNumberOfPlayers);
    }

}
