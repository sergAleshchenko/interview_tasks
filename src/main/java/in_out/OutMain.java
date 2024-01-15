package in_out;

import java.io.*;

public class OutMain {
    public static void main(String[] args) {



        try (FileOutputStream fileOutputStream = new FileOutputStream("data/out.txt", true)) {
            fileOutputStream.write(48);
            byte[] value = {65, 67, 100};

            fileOutputStream.write(value);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }


        System.out.println();
    }
}
