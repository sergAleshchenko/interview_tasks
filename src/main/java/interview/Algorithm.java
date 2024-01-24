package interview;

/**
 * @author Sergei Aleshchenko
 */
public class Algorithm {
    public static void main(String[] args) {
        int[] initialArray = {1, 2, 3, 2, 1};
        int[] initialArray2 = {4, 1, 5, 9, -4};
        System.out.println(getsum(initialArray2));

    }

    public static int getsum(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        int current = 0;

        while (current <= array.length - 1) {
            for (int i = 0; i < current; i++) {
                sumLeft += array[i];
            }

            for (int j = current + 1; j < array.length; j++) {
                sumRight += array[j];
            }

            if (array[current] == sumLeft &&
                    array[current] == sumRight) {
                return array[current];
            } else {
                sumLeft = 0;
                sumRight = 0;
                current++;
            }
        }
        return -1;
    }
}


// 1, 2, 3, 2, 1



