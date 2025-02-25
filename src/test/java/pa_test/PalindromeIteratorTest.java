package pa_test;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sergei Aleshchenko
 */
public class PalindromeIteratorTest {

    @Test
    public void givenListOfStrings_whenPalindromeIterator_thenOnlyPalindromes() {
        List<String> listOfStrings = List.of("oslo", "madam", "car", "deed", "wow", "test");

        PalindromeIterator palindromeIterator = new PalindromeIterator(listOfStrings);

        int count = 0;
        while (palindromeIterator.hasNext()) {
            palindromeIterator.next();
            count++;
        }

        assertEquals(count, 3);
    }

}