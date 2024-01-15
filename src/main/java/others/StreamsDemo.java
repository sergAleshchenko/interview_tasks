package others;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamsDemo {
    public static void main(String[] args) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("H:\\IDEA_PROJECTS\\Learning\\test.txt");
            fileOutputStream.write(65);
            fileOutputStream.close();
            System.out.println("success...");

            FileInputStream fileInputStream = new FileInputStream("H:\\IDEA_PROJECTS\\Learning\\test.txt");
            int read = fileInputStream.read();
            System.out.println((char) read);
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
