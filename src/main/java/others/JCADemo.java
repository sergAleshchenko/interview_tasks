package others;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class JCADemo {
    public static void main(String[] args) throws IOException {
        String code = "ЕСКЕУГЬГМХИФЯ Е УЛП";
        StringBuilder result = new StringBuilder();
        for (char symbol : code.toCharArray()) {
            if (symbol != ' ') {
                symbol = (char) (symbol - 3);
            }
            result.append(symbol);
            System.out.print(symbol);
        }
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        byte[] strToBytes = result.toString().getBytes();
        fileOutputStream.write(strToBytes);
    }
}
