package coding_stories.refactoring_story.service;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CachedPrimeNumberCheckerTest {
    public CachedPrimeNumberChecker checker = new CachedPrimeNumberChecker(4);

    @Test
    public void notOverflowedWhenCacheMaxSize() {
        checker = new CachedPrimeNumberChecker(4);
        checker.calculate(1);
        checker.calculate(2);
        checker.calculate(3);
        checker.calculate(4);
        checker.calculate(5);
        assertEquals(4, checker.getCache().size());
    }

    @Test
    public void cleanCacheTest() {
        checker = new CachedPrimeNumberChecker(4);
        checker.calculate(1);
        checker.calculate(2);
        checker.calculate(3);
        checker.calculate(4);
        checker.cleanCache();
        assertEquals(0, checker.getCache().size());
    }

    @Test
    public void oldestKeyRemovedTest() {
        checker = new CachedPrimeNumberChecker(2);
        checker.calculate(1);
        checker.calculate(2);
        checker.calculate(1);
        checker.calculate(3);
        assertEquals(2, checker.getCache().size());
    }

    @Test
    void isPrimeCheckPrimeTest() {
        String expectedResult = "number is prime";

        assertEquals(expectedResult, checker.performCalculations(1));
        assertEquals(expectedResult, checker.performCalculations(2));
        assertEquals(expectedResult, checker.performCalculations(3));
        assertEquals(expectedResult, checker.performCalculations(5));
        assertEquals(expectedResult, checker.performCalculations(17));
        assertEquals(expectedResult, checker.performCalculations(31));
    }

    @Test
    void isNotPrimeCheckPrimeTest() {
        String expectedResult = "number is not prime";

        assertEquals(expectedResult, checker.performCalculations(4));
        assertEquals(expectedResult, checker.performCalculations(15));
        assertEquals(expectedResult, checker.performCalculations(99));
    }

    @Test
    void isNotPositiveNumberCheckPrimeTest() {
        String expectedResult = "number is not positive";

        assertEquals(expectedResult, checker.performCalculations(-1));
        assertEquals(expectedResult, checker.performCalculations(-15));
        assertEquals(expectedResult, checker.performCalculations(0));
    }
}