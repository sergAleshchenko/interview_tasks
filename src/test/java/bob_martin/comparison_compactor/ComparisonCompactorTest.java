package bob_martin.comparison_compactor;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sergei Aleshchenko
 */
public class ComparisonCompactorTest extends TestCase {

    public void testMessage() {
        String failure = new ComparisonCompactor(0, "b", "c")
                .formatCompactedComparison("expected: <%s> but was: <%s>");

        assertEquals("expected: <[b]> but was: <[c]>", failure);
    }

    public void testStartSame() {
        String failure = new ComparisonCompactor(1, "ba", "bc")
                .formatCompactedComparison("expected: <%s> but was: <%s>");

        assertEquals("expected: <b[a]> but was: <b[c]>", failure);
    }

    public void testEndSame() {
        String failure = new ComparisonCompactor(1, "ab", "cb")
                .formatCompactedComparison("expected: <%s> but was: <%s>");

        assertEquals("expected: <[a]b> but was: <[c]b>", failure);
    }

    public void testSame() {
        String failure = new ComparisonCompactor(1, "ab", "ab")
                .formatCompactedComparison("expected: <%s> but was: <%s>");

        assertEquals("expected: <ab> but was: <ab>", failure);
    }


    public void testNoContextStartAndEndSame() {
        String failure = new ComparisonCompactor(0, "abc", "adc")
                .formatCompactedComparison("expected: <%s> but was: <%s>");

        assertEquals("expected: <...[b]...> but was: <...[d]...>", failure);
    }



    public void testStartAndEndContext() {
        String failure = new ComparisonCompactor(2, "abc", "adc")
                .formatCompactedComparison("expected: <%s> but was: <%s>");

        assertEquals("expected: <a[b]c> but was: <a[d]c>", failure);
    }

    public void testStartAndEndContextWithEllipses() {
        String failure = new ComparisonCompactor(1, "abcde", "abfde")
                .formatCompactedComparison("expected: <%s> but was: <%s>");

        assertEquals("expected: <...b[c]d...> but was: <...b[f]d...>", failure);
    }






}