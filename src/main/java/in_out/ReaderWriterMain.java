package in_out;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterMain {
    public static void main(String[] args) {
        try (
                FileReader fileReader = new FileReader("data/info.txt");
                FileWriter fileWriter = new FileWriter("data/out2.txt")
        ) {
//            fileWriter.write("Java");
            int symbol = fileReader.read();
            System.out.println((char) symbol);

            fileWriter.write(symbol);


            char[] buffer = new char[8];
            int charNum = fileReader.read(buffer);
//            fileWriter.write(buffer, 0, charNum);
            while (charNum != -1) {
                fileWriter.write(buffer, 0, charNum);
                charNum = fileReader.read(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
