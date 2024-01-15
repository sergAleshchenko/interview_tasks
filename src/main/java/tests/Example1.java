package tests;

public class Example1 {
    int i = 0;

    public static void main(String[] args) {
        int i = 1;
//        changeI(i);
        System.out.println(changeI(i));
    }

    public static int changeI(int i) {
        i = 2;
        i *= 2;
        return i;
    }
}
