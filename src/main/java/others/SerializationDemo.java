package others;

import java.io.*;

public class SerializationDemo {

    public void whenSerializingAndDeserializing() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setAge(20);
        person.setName("Joe");

        FileOutputStream fileOutputStream = new FileOutputStream("yourfile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("yourfile.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person p2 = (Person) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(p2.getAge() == person.getAge());
        System.out.println(p2.getName().equals(person.getName()));
    }

    public static void main(String[] args) {
        SerializationDemo serializationDemo = new SerializationDemo();

        try {
            serializationDemo.whenSerializingAndDeserializing();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
