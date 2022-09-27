import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {

    @Test
    void canGenerateAllCards() {
        // given
        List<Card> cardsList = new ArrayList<>();
        Stack<Card> cards = Utils.generateCards();
        int size = cards.size();
        int expectedCountOfEachColor = 25;
        int expectedCountOfWildCards = 8;

        // when
        for (int i = 0; i < size; i++) {
            cardsList.add(cards.pop());
        }
        Map<Integer, Long> cardCounts = cardsList.stream()
                .collect(groupingBy(Card::color, counting()));

        System.out.println(cardCounts);

        // then
        for (int color = 0; color < 4; color++) {
            Long actualCountOfEachColor = cardCounts.get(color);
            assertThat(actualCountOfEachColor).isEqualTo(expectedCountOfEachColor);
        }

        Long actualCountOfWildCards = cardCounts.get(4);
        assertThat(actualCountOfWildCards).isEqualTo(expectedCountOfWildCards);
    }
}