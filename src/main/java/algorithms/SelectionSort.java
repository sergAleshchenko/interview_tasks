package algorithms;

/**
 * @author Sergei Aleshchenko
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {

        // { 9,      4, 76, 2, 4, 55, 4}
        //   i ->
        //   minIdx
        //           j ->

        for (int i = 0; i < arr.length - 1; i++) {

            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 87, 4, 23, 3, 6, 6};

        selectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
