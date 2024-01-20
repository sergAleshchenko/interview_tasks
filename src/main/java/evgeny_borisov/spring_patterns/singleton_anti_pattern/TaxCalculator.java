package evgeny_borisov.spring_patterns.singleton_anti_pattern;

import lombok.AllArgsConstructor;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
public class TaxCalculator {

    private NdsResolver ndsResolver;

    public double withNds(double price) {
        return ndsResolver.getNds() * price + price;
    }


}
