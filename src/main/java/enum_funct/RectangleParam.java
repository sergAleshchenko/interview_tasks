package enum_funct;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public enum RectangleParam implements Supplier<BiFunction> {
    PERIMETER((o1, o2) -> (o1 + o2) * 2),
    SQUARE((o1, o2) -> o1 * o2);

    private BiFunction<Double, Double, Double> biFunction;

    RectangleParam(BiFunction<Double, Double, Double> biFunction) {
        this.biFunction = biFunction;
    }

    @Override
    public BiFunction<Double, Double, Double> get() {
        return biFunction;
    }
}
