package epam;

/**
 * @author Sergei Aleshchenko
 */
public class MinInRotatedSortedArray {


    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3, 4};

        System.out.println(findMin(arr));
    }

    private static int findMin(int[] arr) {
        int lowElement = 0;
        int highElement = arr.length - 1;

        while (lowElement < highElement) {
            if (arr[lowElement] < arr[highElement]) {
                return arr[lowElement];
            }

            // 5, 6, 7, 8, 9, 1, 2, 3, 4
            // low == 5 -> low == 9
            // high == 4
            // mid == 8

            int mid = (lowElement + highElement) / 2;

            if (arr[mid] > arr[highElement]) {
                lowElement = mid + 1;
            } else {
                highElement = mid;
            }
        }

        return arr[lowElement];
    }
}
