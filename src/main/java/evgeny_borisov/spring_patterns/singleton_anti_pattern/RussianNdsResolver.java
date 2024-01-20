package evgeny_borisov.spring_patterns.singleton_anti_pattern;

import lombok.SneakyThrows;

/**
 * @author Sergei Aleshchenko
 */
public class RussianNdsResolver implements NdsResolver {
    private double nds;

    public RussianNdsResolver() {
        nds = getNdsFromCentralBank();
    }

    @SneakyThrows
    private double getNdsFromCentralBank() {
        Thread.sleep(2000);
        return 0.18;
    }

    @Override
    public double getNds() {
        return nds;
    }
}
