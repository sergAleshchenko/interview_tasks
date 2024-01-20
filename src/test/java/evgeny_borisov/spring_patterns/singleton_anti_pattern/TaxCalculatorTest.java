package evgeny_borisov.spring_patterns.singleton_anti_pattern;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Sergei Aleshchenko
 */
public class TaxCalculatorTest {

    @Test
    public void withNds() {
        NdsResolver mock = Mockito.mock(NdsResolver.class);
        Mockito.when(mock.getNds()).thenReturn(0.2);

        double withNds = new TaxCalculator(mock).withNds(100);
        Assert.assertEquals(120, withNds, 0.00001);
    }
}