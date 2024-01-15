import java.util.Random;


public class Point {
    private final int MAX_RANGE;
    final StringBuilder builder = new StringBuilder();
    private int x;
    private String name;

    {
        MAX_RANGE = new Random().nextInt(10_000);
    }
    public Point(int x) {
        this.x = x;
        builder.append("asdf");
//        MAX_RANGE = 1_000;
    }

    public Point(int x, String name) {
        this.x = x;
        this.name = name;
//        MAX_RANGE = new Random().nextInt(10_000);
    }

    final int length() {
        return Math.abs(x);
    }
}
