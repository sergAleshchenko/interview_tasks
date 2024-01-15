package in_out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedMain {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("data/info.txt"))) {
            ArrayList<String> strings = new ArrayList<>();

            bufferedReader.lines().forEach(strings::add);
            System.out.println(strings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
