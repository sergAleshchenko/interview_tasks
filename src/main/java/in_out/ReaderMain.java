package in_out;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReaderMain {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("data/info.txt")){
            int symbol = fileReader.read();
            System.out.println(symbol);

            char[] buffer = new char[8];
            fileReader.skip(2);


            fileReader.read(buffer);
            System.out.println(Arrays.toString(buffer));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
