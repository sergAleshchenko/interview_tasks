package sorting;


/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class SortingDemo {

    // {12, 6, 4, 1, 15, 10, 73, 2, 14}
    //                          i->*
    // j->*

    public static void bubbleSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (sortArr[j + 1] <= sortArr[j]) {
                    int swap = sortArr[j + 1];
                    sortArr[j + 1] = sortArr[j];
                    sortArr[j] = swap;
                }
            }
        }

    }

/*   {12, 6, 4, 1, 15, 10, 73, 2, 14}
     low           mid            high
      i->
                                  <-j
 */
    public static void quickSort(int[] sortArr, int low, int high) {
        if (sortArr.length == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        int border = sortArr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border) {
                i++;
            }
            while (sortArr[j] > border) {
                j--;
            }

            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }

    private static String reverseString(String reverse) {
        char[] chars = reverse.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i <= j) {
            char swap = chars[i];
            chars[i] = chars[j];
            chars[j] = swap;

            i++;
            j--;
        }

        return new String(chars);
    }



    public static void main(String[] args) {
        int[] sortArr = {12, 6, 4, 1, 15, 10, 73, 2, 14};

        int a = 4;
        int b = 7;

//        a = a + b;
//        b = a - b; // this will act like (a+b)-b, now b is equal to a.
//        a = a - b; // (a+b)-a, now, a is equal to b.

        // a = 101
        // b = 001

        a = a ^ b;   //   a = 100
        b = a ^ b;   //   b = 101
        a = a ^ b;   //   a = 001

        System.out.println(a + " " + b);

//        bubbleSort(sortArr);
//        quickSort(sortArr, 0, sortArr.length - 1);

//        for (int i = 0; i < sortArr.length; i++) {
//            System.out.print(sortArr[i] + " ");
//        }


//        System.out.println(reverseString("uhasnamiH"));

    }

}
