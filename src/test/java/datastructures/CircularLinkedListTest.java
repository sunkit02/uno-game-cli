package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircularLinkedListTest {
    CircularLinkedList<Integer> underTest;

    @BeforeEach
    void setUp() {
        underTest = new CircularLinkedList<>();
    }

    @Test
    void canAddAndGetElements() {
        // given
        List<Integer> origVals = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        origVals.forEach(underTest::add);

        // when
        testPointer(origVals, underTest); // test pointer
        List<Integer> extractedVals = extractValues(origVals.size());

        // then
        assertThat(extractedVals).isEqualTo(origVals);

        // display results
        System.out.println("Test: canAddAndGetElements");
        System.out.println("origVals: " + origVals);
        System.out.println("extractedVals: " + extractedVals);
        System.out.println();
    }

    // adding to the front by index
    @Test
    void canAddToFrontByIndex() {
        // given
        List<Integer> origVals = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        origVals.forEach(underTest::add);
        int startIndex = 0;
        Integer newVal = 10;
        origVals.add(startIndex, newVal);
        underTest.add(startIndex, newVal);

        // when
        testPointer(origVals, underTest); // test pointer
        List<Integer> extractedVals = extractValues(origVals.size());

        // then
        assertThat(extractedVals).isEqualTo(origVals);

        // display end states
        System.out.println("Test: canAddToFrontByIndex");
        System.out.println("origVals: " + origVals);
        System.out.println("extractedVals: " + extractedVals);
        System.out.println();
    }

    // adding to the end by index
    @Test
    void canAddToEndByIndex() {
        // given
        List<Integer> origVals = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        origVals.forEach(underTest::add);
        int endIndex = origVals.size();
        Integer newVal = 10;
        origVals.add(endIndex, newVal);
        underTest.add(endIndex, newVal);

        // when
        testPointer(origVals, underTest); // test pointer
        List<Integer> extractedVals = extractValues(origVals.size());

        // then
        assertThat(extractedVals).isEqualTo(origVals);

        // display end states
        System.out.println("Test: canAddToEndByIndex");
        System.out.println("origVals: " + origVals);
        System.out.println("extractedVals: " + extractedVals);
        System.out.println();
    }

    // adding to the middle by index
    @Test
    void canAddToMiddleByIndex() {
        // given
        List<Integer> origVals = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        origVals.forEach(underTest::add);
        int middleIndex = origVals.size() / 2;
        Integer newVal = 10;
        origVals.add(middleIndex, newVal);
        underTest.add(middleIndex, newVal);

        // when
        testPointer(origVals, underTest); // test pointer
        List<Integer> extractedVals = extractValues(origVals.size());


        // then
        assertThat(extractedVals).isEqualTo(origVals);

        // display end states
        System.out.println("Test: canAddToMiddleByIndex");
        System.out.println("origVals: " + origVals);
        System.out.println("extractedVals: " + extractedVals);
        System.out.println();
    }

    // adding to an empty linked list by index
    @Test
    void canAddToEmptyListByIndex() {
        // given
        int origData = 1;
        List<Integer> origVals = new ArrayList<>();
        origVals.add(origData);
        // when
        underTest.add(0, origData);
        testPointer(origVals, underTest);
        List<Integer> extractedVals = extractValues(origVals.size());

        // then
        assertThat(extractedVals).isEqualTo(origVals);

        // display end states
        System.out.println("Test: canAddToEmptyListByIndex");
        System.out.println("origVals: " + origVals);
        System.out.println("extractedVals: " + extractedVals);
        System.out.println();
    }

    // removing the front by index
    @Test
    void canRemoveFromFrontByIndex() {
        // given
        List<Integer> origVals = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        origVals.forEach(underTest::add);

        // when
        for (int i = 0; i < 5; i++) {
            // delete all the elements from the front
            underTest.remove(0);
            origVals.remove(0);
        }

        testPointer(origVals, underTest); // test pointer
        List<Integer> extractedVals = extractValues(origVals.size());

        // then
        assertThat(extractedVals).isEqualTo(origVals);

        // display end states
        System.out.println("Test: canRemoveFromFrontByIndex");
        System.out.println("origVals: " + origVals);
        System.out.println("extractedVals: " + extractedVals);
        System.out.println();
    }

    // removing the back by index
    @Test
    void canRemoveFromBackByIndex() {
        // given
        List<Integer> origVals = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        origVals.forEach(underTest::add);

        // when
        for (int i = 0; i < 5; i++) {
            // delete all the elements from the back
            underTest.remove(underTest.size() - 1);
            origVals.remove(origVals.size() - 1);
        }

        testPointer(origVals, underTest); // test pointer
        List<Integer> extractedVals = extractValues(origVals.size());

        // then
        assertThat(extractedVals).isEqualTo(origVals);

        // display end states
        System.out.println("Test: canRemoveFromBackByIndex");
        System.out.println("origVals: " + origVals);
        System.out.println("extractedVals: " + extractedVals);
        System.out.println();
    }

    // removing the middle by index
    @Test
    void canRemoveFromMiddleByIndex() {
        // given
        List<Integer> origVals = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        origVals.forEach(underTest::add);

        // when
        for (int i = 0; i < 3; i++) {
            // delete all three middle elements from the original list
            underTest.remove(1);
            origVals.remove(1);
        }

        testPointer(origVals, underTest); // test pointer
        List<Integer> extractedVals = extractValues(origVals.size());

        // then
        assertThat(extractedVals).isEqualTo(origVals);

        // display end states
        System.out.println("Test: canRemoveFromMiddleByIndex");
        System.out.println("origVals: " + origVals);
        System.out.println("extractedVals: " + extractedVals);
        System.out.println();
    }

    @Test
    void canThrowIndexOutOfBoundsExceptionWhenAdding() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        values.forEach(underTest::add);

        // when
        int maxIndex = underTest.size();
        int minIndex = 0;
        Integer randomElement = 6;

        // then
        assertThrows(IndexOutOfBoundsException.class,
                () -> underTest.add(maxIndex + 1, randomElement)
        );
        assertThrows(IndexOutOfBoundsException.class,
                () -> underTest.add(minIndex - 1, randomElement)
        );
    }

    @Test
    void canNotThrowIndexOutOfBoundsExceptionWhenAdding() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        values.forEach(underTest::add);

        // when
        int maxIndex = underTest.size();
        int minIndex = 0;
        Integer randomElement = 6;

        // then

        assertDoesNotThrow(() -> underTest.add(maxIndex, randomElement)
        );
        assertDoesNotThrow(() -> underTest.add(minIndex, randomElement));
    }

    @Test
    void canThrowIndexOutOfBoundsExceptionWhenGetting() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        values.forEach(underTest::add);

        // when
        int maxIndex = underTest.size() - 1;
        int minIndex = 0;

        // then
        assertThrows(IndexOutOfBoundsException.class,
                () -> underTest.get(maxIndex + 1)
        );
        assertThrows(IndexOutOfBoundsException.class,
                () -> underTest.get(minIndex - 1)
        );
    }

    @Test
    void canNotThrowIndexOutOfBoundsExceptionWhenGetting() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        values.forEach(underTest::add);

        // when
        int maxIndex = underTest.size() - 1;
        int minIndex = 0;

        // then

        assertDoesNotThrow(() -> underTest.get(maxIndex)
        );
        assertDoesNotThrow(() -> underTest.get(minIndex));
    }

    @Test
    void canThrowIndexOutOfBoundsExceptionWhenRemoving() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        values.forEach(underTest::add);

        // when
        int maxIndex = underTest.size() - 1;
        int minIndex = 0;

        // then
        assertThrows(IndexOutOfBoundsException.class,
                () -> underTest.remove(maxIndex + 1)
        );
        assertThrows(IndexOutOfBoundsException.class,
                () -> underTest.remove(minIndex - 1)
        );
    }

    @Test
    void canNotThrowIndexOutOfBoundsExceptionWhenRemoving() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        values.forEach(underTest::add);

        // when
        int maxIndex = underTest.size() - 1;
        int minIndex = 0;

        // then
        assertDoesNotThrow(() -> underTest.remove(maxIndex)
        );
        assertDoesNotThrow(() -> underTest.remove(minIndex)
        );
    }

    @Test
    void canValidateIndexWhenListIsNotEmpty() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        values.forEach(underTest::add);

        // when
        int maxIndex = underTest.size() - 1;
        int minIndex = 0;

        // then
        assertThrows(IndexOutOfBoundsException.class,
                () -> underTest.listIterator(maxIndex + 1));
        assertThrows(IndexOutOfBoundsException.class,
                () -> underTest.listIterator(minIndex - 1));

        assertDoesNotThrow(() -> underTest.listIterator(maxIndex));
        assertDoesNotThrow(() -> underTest.listIterator(minIndex));
    }

    @Test
    void canValidateIndexWhenListIsEmpty() {
        // given
        assert underTest.isEmpty();

        // then
        assertThrows(IndexOutOfBoundsException.class,
                () -> underTest.listIterator(0));
    }

    @Test
    void canGetNextElementWithListIterator() {
        // given
        List<Integer> origValues = List.of(1, 2, 3, 4, 5);
        origValues.forEach(underTest::add);
        int n = origValues.size();
        int startingIndex = underTest.size() - 1;

        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(startingIndex);
        List<Integer> extractedValues = new ArrayList<>();
        // when
        for (int i = 0; i < n; i++) {
            extractedValues.add(underTestIterator.next());
        }

        // then
        assertThat(extractedValues).isEqualTo(origValues);

    }

    @Test
    void canGetPreviousElementWithListIterator() {
        // given
        List<Integer> origValues = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        origValues.forEach(underTest::add);
        Collections.reverse(origValues);
        int n = origValues.size();
        int startIndex = 0;

        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(startIndex);
        List<Integer> extractedValues = new ArrayList<>();
        // when
        for (int i = 0; i < n; i++) {
            extractedValues.add(underTestIterator.previous());
        }

        // then
        assertThat(extractedValues).isEqualTo(origValues);
    }

    @Test
    void canCheckIfNextElementExistsWithListIterator() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        values.forEach(underTest::add);
        int n = values.size();
        int startIndex = 0;
        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(startIndex);
        // then
        for (int i = 0; i < n; i++) {
            assertThat(underTestIterator.hasNext()).isTrue();
            underTestIterator.next();
        }
    }

    @Test
    void canCheckIfPreviousElementExistsWithListIterator() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        values.forEach(underTest::add);
        int n = values.size();
        int startIndex = 0;
        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(startIndex);
        // then
        for (int i = 0; i < n; i++) {
            assertThat(underTestIterator.hasPrevious()).isTrue();
            underTestIterator.previous();
        }
    }

    @Test
    void canIterateContinuouslyWithNextUsingListIterator() {
        // given
        List<Integer> origValues = List.of(1, 2, 3, 4, 5);
        origValues.forEach(underTest::add);
        int n = origValues.size();
        int startIndex = underTest.size() - 1; // to call next at 0
        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(startIndex);
        // then
        for (int i = 0, j = 0; j < (n << 1);j++, i++) {
            if (i >= n) i = 0;
            assertThat(underTestIterator.next())
                    .isEqualTo(origValues.get(i));
        }
    }

    @Test
    void canIterateContinuouslyWithPreviousUsingListIterator() {
        // given
        List<Integer> origValues = List.of(1, 2, 3, 4, 5);
        origValues.forEach(underTest::add);
        int n = origValues.size();
        int startIndex = 0;
        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(startIndex);
        // then
        for (int i = (n - 1), j = 0; j < (n << 1);j++, i--) {
            if (i < 0) i = n - 1;
            assertThat(underTestIterator.previous())
                    .isEqualTo(origValues.get(i));
        }
    }

    @Test
    void canGetNextIndex() {
        // given
        List<Integer> values = List.of(1, 2, 3);
        values.forEach(underTest::add);
        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(0);
        int expectedNextIndex = 1;

        // when
        int nextIndex = underTestIterator.nextIndex();

        // then
        assertThat(nextIndex).isEqualTo(expectedNextIndex);
    }

    @Test
    void canGetPreviousIndex() {
        // given
        List<Integer> values = List.of(1, 2, 3);
        values.forEach(underTest::add);
        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(2);
        int expectedPreviousIndex = 1;

        // when
        int nextIndex = underTestIterator.previousIndex();
        // then
        assertThat(nextIndex).isEqualTo(expectedPreviousIndex);
    }

    @Test
    void canGetNextIndexInCirculation() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4);
        values.forEach(underTest::add);
        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(underTest.size() - 1);
        // then
        int size = underTest.size();
        for (int i = 0, j = 0; j < size << 2; i++, j++) {
            if (i >= size) i = 0;
            int actual = underTestIterator.nextIndex();
            underTestIterator.next();
            assertThat(actual).isEqualTo(i);
        }
    }

    @Test
    void canGetPreviousIndexInCirculation() {
        // given
        List<Integer> values = List.of(0, 1, 2, 3, 4);
        values.forEach(underTest::add);
        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(0);

        List<Integer> indexes = new ArrayList<>();
        List<Integer> valuesAtIndex = new ArrayList<>();
        // when
        int size = underTest.size();
        for (int i = 0; i < size << 2; i++) {
            int index = underTestIterator.previousIndex();
            Integer valueAtIndex = underTestIterator.previous();
            assertThat(index).isEqualTo(valueAtIndex);
            indexes.add(index);
            valuesAtIndex.add(valueAtIndex);
        }

        System.out.println("canGetPreviousIndexInCirculation");
        System.out.println("Indexes：" + indexes);
        System.out.println("Values : " + valuesAtIndex);
    }

    @Test
    void canGetPreviousAndNextAlternating() {
        // given
        List<Integer> values = List.of(1, 2, 3);
        values.forEach(underTest::add);
        LinkedListIterator<Integer> underTestIterator =
                underTest.listIterator(0);

        List<Integer> expectedValues = new ArrayList<>();
        List<Integer> actualValues = new ArrayList<>();
        // when
        actualValues.add(underTestIterator.previous());
        expectedValues.add(3);
        actualValues.add(underTestIterator.next());
        expectedValues.add(1);
        actualValues.add(underTestIterator.next());
        expectedValues.add(2);
        actualValues.add(underTestIterator.previous());
        expectedValues.add(1);
        actualValues.add(underTestIterator.previous());
        expectedValues.add(3);
        actualValues.add(underTestIterator.previous());
        expectedValues.add(2);
        actualValues.add(underTestIterator.previous());
        expectedValues.add(1);
        actualValues.add(underTestIterator.previous());
        expectedValues.add(3);
        actualValues.add(underTestIterator.next());
        expectedValues.add(1);
        actualValues.add(underTestIterator.next());
        expectedValues.add(2);
        actualValues.add(underTestIterator.next());
        expectedValues.add(3);
        actualValues.add(underTestIterator.next());
        expectedValues.add(1);

        // then
        assertThat(actualValues).isEqualTo(expectedValues);

    }

    @Test
    void canGetSize() {
        // given
        List<Integer> vals = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        vals.forEach(underTest::add);
        // add values then delete values to check if size method will
        // update as expected
        int numberOfValuesToAdd = 5;
        for (int i = 0; i < numberOfValuesToAdd; i++) {
            vals.add(i);
            underTest.add(i);
        }
        int expectedSizeAfterAdding = vals.size();
        int actualSizeAfterAdding = underTest.size();

        int numberOfValuesToRemove = 5;
        for (int i = 0; i < numberOfValuesToRemove; i++) {
            vals.remove(0);
            underTest.remove(0);
        }
        int expectedSizeAfterRemoving = vals.size();
        int actualSizeAfterRemoving = underTest.size();

        // then
        assertThat(actualSizeAfterAdding).isEqualTo(expectedSizeAfterAdding);
        assertThat(actualSizeAfterRemoving).isEqualTo(expectedSizeAfterRemoving);
    }

    @Test
    void canGetIsEmpty() {
        // given
        boolean isEmptyBefore = underTest.isEmpty();
        underTest.add(1);
        boolean isNotEmptyAfter = underTest.isEmpty();
        // then
        assertThat(isEmptyBefore).isTrue();
        assertThat(isNotEmptyAfter).isFalse();
    }

    @Test
    void canReturnTrueForListsWithIdenticalElements() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        CircularLinkedList<Integer> otherList = new CircularLinkedList<>();
        values.forEach(value -> {
            underTest.add(value);
            otherList.add(value);
        });

        // when
        boolean isEqual = underTest.equals(otherList);

        // then
        assertThat(isEqual).isTrue();
    }

    @Test
    void canReturnFalseForListsWithNonidenticalElements() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        List<Integer> otherValues = List.of(1, 2, 4, 3, 5);
        CircularLinkedList<Integer> otherList = new CircularLinkedList<>();

        for (int i = 0; i < values.size(); i++) {
            underTest.add(values.get(i));
            otherList.add(otherValues.get(i));
        }

        // when
        boolean isEqual = underTest.equals(otherList);

        // then
        assertThat(isEqual).isFalse();
    }

    @Test
    void canReturnFalseForListsWithDifferentSizes() {
        // given
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        List<Integer> otherValues = List.of(1, 2, 3, 4);
        CircularLinkedList<Integer> otherList = new CircularLinkedList<>();

        values.forEach(underTest::add);
        otherValues.forEach(otherList::add);

        // when
        boolean isEqual = underTest.equals(otherList);

        // then
        assertThat(isEqual).isFalse();
    }

    @Test
    void canToString() {
        // given
        List<Integer> values = List.of(1, 2, 3);

        // when
        String emptyToString = underTest.toString();
        String expectedEmptyToString = "[]";

        values.forEach(underTest::add);
        String withElementsToString = underTest.toString();
        String expectedWithElementsToString = "[1, 2, 3]";

        // then
        assertThat(emptyToString).
                isEqualTo(expectedEmptyToString);

        assertThat(withElementsToString).
                isEqualTo(expectedWithElementsToString);
    }


    /**
     * Utility method to move the pointer to ensure that it is
     * pointing at the correct node after an operation
     * @param origVals the values to compare linked list to
     * @param underTest the linked list instance currently being tested
     */
    private void testPointer(
            List<Integer> origVals,
            LinkedList<Integer> underTest) {
        // track original end of lists
        int origValsLastIndex = origVals.size();
        int underTestLastIndex = underTest.size();
        // add elements
        for (int i = 10; i < 20; i++) {
            origVals.add(i);
            underTest.add(i);
        }
        // remove half of the added elements
        for (int i = 0; i < 5; i++) {
            origVals.remove(origValsLastIndex);
            underTest.remove(underTestLastIndex);
        }
        // add five other elements
        for (int i = 100; i < 105; i++) {
            origVals.add(i);
            underTest.add(i);
        }

        // TODO: iterate through entire linked list (implement in future)
    }

    /**
     * Utility method to extract the number of elements in the linked list
     * into a {@code List} object
     * @param origValsSize the number of elements to be extracted
     * @return a {@code List} containing all the extracted elements
     */
    private List<Integer> extractValues(int origValsSize) {
        List<Integer> extractedVals = new ArrayList<>();
        for (int i = 0; i < origValsSize; i++) {
            extractedVals.add(underTest.get(i));
        }
        return extractedVals;
    }


}