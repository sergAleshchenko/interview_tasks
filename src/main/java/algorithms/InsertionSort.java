package algorithms;

/**
 * @author Sergei Aleshchenko
 */
public class InsertionSort {

    public static void insertionSort(int arr[]) {

        // {3, 4, 76, 2, 4, 2, 4}
        //            i->
        //       <-j
        //
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 87, 4, 23, 3, 6, 6};

        insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
