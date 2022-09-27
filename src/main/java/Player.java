import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public List<Card> hand() {
        return hand;
    }

    public int handSize() {
        return hand.size();
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}
