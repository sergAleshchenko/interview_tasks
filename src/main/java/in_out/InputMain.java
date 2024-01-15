package in_out;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class InputMain {
    public static void main(String[] args) {

        FileInputStream input = null;
        try {
            input = new FileInputStream("data/info.txt");
            int code = input.read();
            System.out.println(code + " char = " + (char) code);

            byte[] bytes = new byte[16];
            int num = input.read(bytes);
            System.out.println("num = " + num);
            System.out.println(Arrays.toString(bytes));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
