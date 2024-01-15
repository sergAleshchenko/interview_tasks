package enum_funct;

public class Runner {
    public static void main(String[] args) {
        RectangleAction rectangleAction = new RectangleAction();

        Double result = rectangleAction.action(RectangleParam.PERIMETER, 1.0, 7.0);

        System.out.println(result);
    }
}
