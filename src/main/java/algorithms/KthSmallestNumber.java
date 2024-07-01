package algorithms;

import java.util.Arrays;

/**
 * @author Sergei Aleshchenko
 */
public class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {

        quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
        return nums[k - 1];
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 3);
        System.out.println();
        System.out.println(result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 4);        System.out.println();
        System.out.println(result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println();
        System.out.println(result);
    }
}
