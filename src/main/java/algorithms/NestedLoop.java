package algorithms;

/**
 * @author Sergei Aleshchenko
 */
public class NestedLoop {

    public static void main(String[] args) {

        long start = System.nanoTime();

        int n = 1000000;
        int sum = 0;
        double pie = 3.14;

        for (int var = 0; var < n; var += 3) {
            System.out.println("Pie: " + pie);
            for (int j = 0; j < n; j = j + 2) {
                sum++;
            }
            System.out.println("Sum = " + sum);
        }

        long end = System.nanoTime();

        System.out.println((end - start) * 0.000000001 + "sec");
    }
}
