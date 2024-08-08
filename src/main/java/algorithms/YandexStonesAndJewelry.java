package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sergei Aleshchenko
 */
public class YandexStonesAndJewelry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String J = reader.readLine();
        String S = reader.readLine();

        int result = 0;

        for(int s = 0; s < S.length(); s++) {
            if(J.indexOf(S.charAt(s)) != -1) {
                result++;
            }
        }


        System.out.println(result);
    }
}
