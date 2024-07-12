package algorithms;

/**
 * @author Sergei Aleshchenko
 */
public class LinearSearch {

    public static int linearSearch(int[] arr, int x) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 4, 2, 1, 8, 6, 4, 2};

        int result = linearSearch(arr, 0);
        System.out.println(result);
    }
}
