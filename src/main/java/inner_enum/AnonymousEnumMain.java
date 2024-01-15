package inner_enum;

import java.util.Arrays;

public class AnonymousEnumMain {
    public static void main(String[] args) {
        Arrays.stream(Shape.values()).forEach(e -> System.out.println(e.computeSquare()));
    }
}
