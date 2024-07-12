package algorithms;

import java.util.Arrays;

/**
 * @author Sergei Aleshchenko
 */
public class HeapSort {


    // { 1, 3, 7, 1, 3, 5, 7, 4 }
    public static void heapSort(int arr[]) {
        int N = arr.length;

        // build heap
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }

        // extract elements from heap
        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < N && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }

    public static void main(String[] args) {
        int arr[] = {345, 3, 7, 1, 44, 5, 7, 4 };
        heapSort(arr);

        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
}
