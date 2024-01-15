package in_out;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationMain {
    public static void main(String[] args) {
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream("data/out.dat"));
            Student student = (Student) input.readObject();

            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
