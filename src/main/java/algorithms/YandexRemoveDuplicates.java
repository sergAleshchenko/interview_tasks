package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.function.Predicate;

/**
 * @author Sergei Aleshchenko
 */
public class YandexRemoveDuplicates {
    static final String input = "input.txt";
    static final String output = "output.txt";
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader(input));
        bw = new BufferedWriter(new FileWriter(output));

        int n = Integer.valueOf(br.readLine());

        String last = "";
        String curr = last;

        for (int i = 0; i < n; i++) {
            curr = br.readLine().intern();

            if (last != curr) {
                last = curr;
                bw.write(curr);
                bw.write('\n');
            }
        }
        br.close();
        bw.close();

    }
}
