package algorithms;

import java.io.*;
import java.util.Arrays;


public class YandexAnagrams {

    static final String input = "input.txt";
    static final String output = "output.txt";
    static BufferedReader br;
    static BufferedWriter bw;

    private static int isAnagram(String a, String b) {
        byte[] aBytes = a.toLowerCase().getBytes();
        byte[] bBytes = b.toLowerCase().getBytes();

        if(aBytes.length != bBytes.length) return 0;

        Arrays.sort(aBytes);
        Arrays.sort(bBytes);

        for (int i = 0; i < aBytes.length; i++) {
            if(aBytes[i] == bBytes[i]) {
                continue;
            } else {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader(input));
        bw = new BufferedWriter(new FileWriter(output));

        String a = br.readLine();
        String b = br.readLine();


        bw.write(String.valueOf(isAnagram(a, b)));
        bw.newLine();

        br.close();
        bw.close();
    }
}