import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Utils {
    public static Stack<Card> generateCards() {
        Stack<Card> stack = new Stack<>();
        List<Card> cards = new ArrayList<>();
        // cards not wild
        for (int n = 0; n < 2; n++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
                    if (n > 0 && j == 0) {
                        continue;
                    }
                    cards.add(new Card(j, i));
                }
            }
        }
        // wild cards
        for (int i = 0; i < 8; i++) {
            if (i < 4) {
                cards.add(new Card(13, 4));
            }
            else {
                cards.add(new Card(14, 4));
            }
        }

        shuffleCards(cards);

        cards.forEach(stack::push);
        return stack;
    }

    private static void shuffleCards(List<Card> cards) {

        SecureRandom random = new SecureRandom();
        int size = cards.size();
        for (int i = 0; i < 10000; i++) {
            int rng1 = random.nextInt(size);
            int rng2 = random.nextInt(size);
            Card card1 = cards.get(rng1);
            Card card2 = cards.get(rng2);
            cards.set(rng1, card2);
            cards.set(rng2, card1);
        }
    }
}
