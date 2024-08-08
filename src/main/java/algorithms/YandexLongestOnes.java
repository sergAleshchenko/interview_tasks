package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sergei Aleshchenko
 */
public class YandexLongestOnes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        int[] arr = new int[n];
        int maxLength = 0;


        while (n > 0) {
            arr[arr.length - n] = Integer.valueOf(reader.readLine());
            n--;
        }

        // 1, 0, 1, 0, 1, 1, 1, 0

        for (int j = 0; j < arr.length; j++) {

            if (arr[j] == 1) {
                int i = j;
                int curLength = 0;

                while (i < arr.length && arr[i] == 1) {
                    i++;
                    curLength++;
                }

                if (curLength >= maxLength) {
                    maxLength = curLength;
                }
            }

        }

        System.out.println(maxLength);

    }
}
