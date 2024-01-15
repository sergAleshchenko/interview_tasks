package inner_enum;

import java.util.StringJoiner;

public enum Shape {
    RECTANGLE (2, 3) {
        public double computeSquare() {
            return this.getA() * this.getB();
    }},


    TRIANGLE (4, 5){
        public double computeSquare() {
            return this.getA() * this.getB() / 2;
        }
    };

    private double a;
    private double b;

    Shape(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public abstract double computeSquare();


    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Shape.class.getSimpleName() + "[", "]")
                .add("a=" + a)
                .add("b=" + b)
                .toString();
    }
}
