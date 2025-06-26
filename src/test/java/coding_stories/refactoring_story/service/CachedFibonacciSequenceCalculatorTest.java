package coding_stories.refactoring_story.service;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CachedFibonacciSequenceCalculatorTest {
    public CachedFibonacciSequenceCalculator calculator = new CachedFibonacciSequenceCalculator(4);

    @Test
    public void notOverflowedWhenCacheMaxSize() {
        calculator = new CachedFibonacciSequenceCalculator(4);
        calculator.calculate(1);
        calculator.calculate(2);
        calculator.calculate(3);
        calculator.calculate(4);
        calculator.calculate(5);
        assertEquals(4, calculator.getCache().size());
    }

    @Test
    public void cleanCacheTest() {
        calculator = new CachedFibonacciSequenceCalculator(4);
        calculator.calculate(1);
        calculator.calculate(2);
        calculator.calculate(3);
        calculator.calculate(4);
        calculator.cleanCache();
        assertEquals(0, calculator.getCache().size());
    }

    @Test
    public void oldestKeyRemovedTest() {
        calculator = new CachedFibonacciSequenceCalculator(2);
        calculator.calculate(1);
        calculator.calculate(2);
        calculator.calculate(1);
        calculator.calculate(3);
        assertEquals(2, calculator.getCache().size());
    }

    @Test
    void calculateFibonacciPositiveNumberTest() {
        calculator.calculate(1);

        assertEquals("1", calculator.calculate(1));
        assertEquals("1", calculator.calculate(2));
        assertEquals("2", calculator.calculate(3));
        assertEquals("3", calculator.calculate(4));
        assertEquals("5", calculator.calculate(5));
        assertEquals("8", calculator.calculate(6));
    }

    @Test
    void calculateFibonacciZeroTest() {
        assertEquals("0", calculator.calculate(0));
    }

    @Test
    void calculateFibonacciNegativeNumberTest() {
        assertEquals("1", calculator.calculate(-1));
        assertEquals("1", calculator.calculate(-2));
        assertEquals("1", calculator.calculate(-3));
        assertEquals("1", calculator.calculate(-6));
        assertEquals("1", calculator.calculate(-15));
    }
}