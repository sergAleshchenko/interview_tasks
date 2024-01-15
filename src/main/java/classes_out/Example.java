package classes_out;


class Quest1 {
    private void show(int i) {
        System.out.println("1");
    }
}

public class Example extends Quest1 {
    public void show(int i) {
        System.out.println("2");
    }

    public static void main(String[] args) {
//        Quest1 example = new Example();
//        int i = '1';
//        ((Example)example).show(i);
    }
}
