package andrei_pangin;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sergei Aleshchenko
 */
public class Dictionary {

    private static void testRandomRead(long[] array, int bound) {
        long startTime = System.nanoTime();

        for (int i = 0; i < 2000000000; i++) {
            int index = ThreadLocalRandom.current().nextInt(bound);
            array[index]++;
        }

        long endTime = System.nanoTime();
        System.out.printf("Time spent: %.3f\n", (endTime - startTime) / 1e9);

    }


    // array = [0, 0, ... , 0] (1024 * 1024)
    public static void test128K() {
        long[] array = new long[1024 * 1024];
        testRandomRead(array, 16384);
    }


    // array = [0, 0, ... , 0] (1024 * 1024)
    public static void test8M() {
        long[] array = new long[1024 * 1024];
        testRandomRead(array, 1024 * 1024);
    }


    public static void main(String[] args) {
        new Thread(Dictionary::test128K).start();
        new Thread(Dictionary::test8M).start();
    }
}
