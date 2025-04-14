package epam;

/**
 * @author Sergei Aleshchenko
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 7;
        System.out.println(searchElement(arr, key));
    }

    private static int searchElement(int[] arr, int key) {
        int n = arr.length;
        int pivot = findPivot(arr, 0, n - 1);

        if (arr[pivot] == key) {
            return pivot;
        }

        // 5, 6, 7, 8, 9, 10, 1, 2, 3

        if (pivot == 0) {
            return binarySearch(arr, 0, n - 1, key);
        }

        if (arr[0] <= key) {
            return binarySearch(arr, 0, pivot - 1, key);
        } else {
            return binarySearch(arr, pivot + 1, n - 1, key);
        }
    }

    private static int findPivot(int[] arr, int low, int high) {
        int lowElement = 0;
        int highElement = arr.length - 1;

        while (lowElement < highElement) {
            if (arr[lowElement] < arr[highElement]) {
                return arr[lowElement];
            }

            int mid = (lowElement + highElement) / 2;

            if (arr[mid] > arr[highElement]) {
                lowElement = mid + 1;
            } else {
                highElement = mid;
            }
        }

        return lowElement;
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
