import java.util.Stack;

public class UnoGame {
    public static void main(String[] args) {
        Stack<Card> cards = Utils.generateCards();
        System.out.println(cards);
    }
}
