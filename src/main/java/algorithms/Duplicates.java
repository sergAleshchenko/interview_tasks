package algorithms;

import java.io.*;

/**
 * @author Sergei Aleshchenko
 */
public class Duplicates {

    static final String input = "input.txt";
    static final String output = "output.txt";
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader(input));
        bw = new BufferedWriter(new FileWriter(output));


        // 5
        // 2
        // 2
        // 4
        // 4
        // 8

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

        // 2
        // 4
        // 8

        bw.close();
        br.close();

    }
}
