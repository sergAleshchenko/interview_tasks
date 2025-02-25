package pa_test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Sergei Aleshchenko
 */
public class PalindromeIterator implements Iterator<String> {

    private int currentIndex;
    private List<String> listOfStrings;

    public PalindromeIterator(List<String> listOfStrings) {
        this.listOfStrings = listOfStrings;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < listOfStrings.size()) {
            String currentString = listOfStrings.get(currentIndex);
            if (isPalindrome(currentString)) {
                return true;
            }
            currentIndex++;
        }

        return false;
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return listOfStrings.get(currentIndex++);
    }

    private boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
