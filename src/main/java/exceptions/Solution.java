package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        int num[] = {10, 20, 30, 40, 50, 60};


        try {
            System.out.println(num[7]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oooooops!");
        }
    }

    public static void readFile(String filePath) throws IOException, FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
