package coding_stories.refactoring_story.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceIntegrationTest {
    private static final String CHECK_PRIME = "check prime";
    private static final String CALCULATE_FIBONACCI = "calculate fibonacci";
    private static final String GET_CACHES = "get caches";
    private static final String CLEAN_CACHES = "clean caches";

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 17, 31})
    void isPrimeCheckPrimeTest(int number) throws Exception {
        MathService mathService = new MathServiceTestDouble(4, 4);

        String expectedResult = "number is prime";

        String actualResult = mathService.calculate(number, CHECK_PRIME);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 15, 99})
    void isNotPrimeCheckPrimeTest(int number) throws Exception {
        MathService mathService = new MathServiceTestDouble(4, 4);

        String expectedResult = "number is not prime";

        String actualResult = mathService.calculate(number, CHECK_PRIME);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -15, 0})
    void isNotPositiveNumberCheckPrimeTest(int number) throws Exception {
        MathService mathService = new MathServiceTestDouble(4, 4);

        String expectedResult = "number is not positive";

        String actualResult = mathService.calculate(number, CHECK_PRIME);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "1,2", "2,3", "3,4", "5,5", "8,6"})
    void calculateFibonacciPositiveNumberTest(String expected, int number) throws Exception {
        MathService mathService = new MathServiceTestDouble(4, 4);

        String actual = mathService.calculate(number, CALCULATE_FIBONACCI);

        assertEquals(expected, actual);
    }

    @Test
    void calculateFibonacciZeroTest() throws Exception {
        MathService mathService = new MathServiceTestDouble(4, 4);

        String actual = mathService.calculate(0, CALCULATE_FIBONACCI);

        assertEquals("0", actual);
    }

    @ParameterizedTest
    @CsvSource({"1,-1", "1,-2", "1,-3", "1,-6"}) // TODO : check requirements and fix if it is a bug
    void calculateFibonacciNegativeNumberTest(String expected, int number) throws Exception {
        MathService mathService = new MathServiceTestDouble(4, 4);

        String actual = mathService.calculate(number, CALCULATE_FIBONACCI);

        assertEquals(expected, actual);
    }

    @Test
    void getCachesOverCapacityTest() throws Exception {
        MathService mathService = new MathServiceTestDouble(2, 2);

        mathService.calculate(0, CHECK_PRIME);
        mathService.calculate(1, CALCULATE_FIBONACCI);
        mathService.calculate(1, CHECK_PRIME);
        mathService.calculate(2, CALCULATE_FIBONACCI);
        mathService.calculate(2, CHECK_PRIME);
        mathService.calculate(4, CALCULATE_FIBONACCI);
        mathService.calculate(4, CALCULATE_FIBONACCI);
        mathService.calculate(4, CHECK_PRIME);
        mathService.calculate(4, CHECK_PRIME);

        String expected = "fibonacci cache: {4 : 3; 2 : 1; } prime cache: {4 : number is not prime; 2 : number is prime; } ";

        assertEquals(expected, mathService.calculate(0, GET_CACHES));
        assertEquals(expected, mathService.calculate(1, GET_CACHES));
        assertEquals(expected, mathService.calculate(-1, GET_CACHES));
    }

    @Test
    void getCachesZeroOrNegativeCapacityTest() throws Exception {
        MathService mathService = new MathServiceTestDouble(0, 0);

        mathService.calculate(0, CHECK_PRIME);
        mathService.calculate(1, CALCULATE_FIBONACCI);
        mathService.calculate(1, CHECK_PRIME);
        mathService.calculate(2, CALCULATE_FIBONACCI);
        mathService.calculate(2, CHECK_PRIME);
        mathService.calculate(4, CALCULATE_FIBONACCI);
        mathService.calculate(4, CALCULATE_FIBONACCI);
        mathService.calculate(4, CHECK_PRIME);
        mathService.calculate(4, CHECK_PRIME);

        String expected = "fibonacci cache: {1 : 1; 2 : 1; 4 : 3; } prime cache: {0 : number is not positive; 1 : number is prime; 2 : number is prime; 4 : number is not prime; } ";

        assertEquals(expected, mathService.calculate(7, GET_CACHES));
    }

    @Test
    void getCachesNoActionsEmptyTest() throws Exception {
        MathService mathService = new MathServiceTestDouble(2, 2);

        String expected = "fibonacci cache: {} prime cache: {} ";

        assertEquals(expected, mathService.calculate(7, GET_CACHES));
    }

    @Test
    public void throwExceptionWhenNegativeCapacity() {
        assertThrows(IllegalArgumentException.class,
                () -> new MathService(-1, 2));
    }

    @Test
    void cleanCachesTest() throws Exception {
        MathService mathService = new MathServiceTestDouble(4, 4);

        mathService.calculate(0, CHECK_PRIME);
        mathService.calculate(1, CALCULATE_FIBONACCI);
        mathService.calculate(1, CHECK_PRIME);
        mathService.calculate(2, CALCULATE_FIBONACCI);
        mathService.calculate(2, CHECK_PRIME);
        mathService.calculate(4, CALCULATE_FIBONACCI);
        mathService.calculate(4, CALCULATE_FIBONACCI);
        mathService.calculate(4, CHECK_PRIME);
        mathService.calculate(4, CHECK_PRIME);

        String cleanCacheResult = "done";
        String emptyCacheResult = "fibonacci cache: {} prime cache: {} ";

        assertEquals(cleanCacheResult, mathService.calculate(0, CLEAN_CACHES));
        assertEquals(emptyCacheResult, mathService.calculate(-1, GET_CACHES));
    }

    @ParameterizedTest
    @CsvSource({"someTextA,0,someTextA0", "someTextB,-3,someTextB-3", "someTextC,7,someTextC7"})
    void calculateWithNotRegisteredOperationTest(String operation, int number, String expected) throws Exception {
        MathService mathService = new MathServiceTestDouble(4, 4);

        String actual = mathService.calculate(number, operation);

        assertEquals(expected, actual);
    }
}