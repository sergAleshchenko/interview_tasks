package in_out;

import java.io.*;

public class ReaderWriterMain2 {
    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader =
                        new BufferedReader(new FileReader("data/info.txt"));
                BufferedWriter bufferedWriter =
                        new BufferedWriter(new FileWriter("data/out.txt"))
        ) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null)
            {
                bufferedWriter.write(line, 0, line.length());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
