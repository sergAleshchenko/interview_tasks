package algorithms;

import java.util.Arrays;

/**
 * @author Sergei Aleshchenko
 */
public class MergeSort {

    private static int[] mergeSort(int[] arr) {
        int[] buffer1 = Arrays.copyOf(arr, arr.length);
        int[] buffer2 = new int[arr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, arr.length);

        return result;
    }

    private static int[] mergeSortInner(int[] buffer1, int[] buffer2,
                                        int startIndex, int endIndex) {

        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);


        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;

        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;

        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2] ?
                    sorted1[index1++] : sorted2[index2++];
        }

        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }

        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {11, 5, 7, 2, 5, 33, 7, 1, 0};
        int[] result = mergeSort(arr);

        Arrays.stream(result).forEach(x -> System.out.print(x + " "));
    }
}
