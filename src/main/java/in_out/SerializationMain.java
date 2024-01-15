package in_out;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationMain {
    public static void main(String[] args) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("data/out.dat"));


            Student student = new Student("Sergei", 1234, "password1234");
            output.writeObject(student);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
