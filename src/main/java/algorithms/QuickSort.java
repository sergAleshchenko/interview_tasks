package algorithms;

import java.util.Arrays;

/**
 * @author Sergei Aleshchenko
 */
public class QuickSort {

    //{ 11, 5, 7, 2, 5,  33, 7, 1, 0}
    //  i->          mid         <-j


    private static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0 || low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int borderElem = arr[middle];

        int i = low, j = high;

        while (i <= j) {
            while (arr[i] < borderElem) i++;
            while (arr[j] > borderElem) j--;

            if (i <= j) {
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);
    }


    public static void main(String[] args) {
        int[] arr = {11, 5, 7, 2, 5, 33, 7, 1, 0};
        quickSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
}
