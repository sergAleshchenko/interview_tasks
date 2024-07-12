package algorithms;

/**
 * @author Sergei Aleshchenko
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int low, int high,  int x) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == x) {
            return mid;
        }

        if (x < arr[mid]) {
            return binarySearch(arr, low, mid - 1, x);
        } else if (x > arr[mid]) {
            return binarySearch(arr, mid + 1, high, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 22, 33, 66, 255, 765};

        int result = binarySearch(arr, 0, arr.length, 765);
        System.out.println(result);
    }
}
