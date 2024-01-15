package others;

import java.io.*;

public class CountryDemo {

    public void serializeDeserializeCountry() throws IOException, ClassNotFoundException {
        Country c = new Country();
        c.setCode(374);
        c.setName("Armenia");

        FileOutputStream fileOutputStream = new FileOutputStream("country.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        c.writeExternal(objectOutputStream);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("country.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Country c2 = new Country();
        c2.readExternal(objectInputStream);

        objectInputStream.close();
        fileInputStream.close();

        System.out.println(c2.getCode() == c.getCode());
        System.out.println(c2.getName().equals(c.getName()));
    }

    public static void main(String[] args) {
        CountryDemo countryDemo = new CountryDemo();
        try {
            countryDemo.serializeDeserializeCountry();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
