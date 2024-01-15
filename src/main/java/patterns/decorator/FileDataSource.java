package patterns.decorator;


import lombok.AllArgsConstructor;

import java.io.*;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
public class FileDataSource implements DataSource {
    private String name;

    @Override
    public void writeData(String data) {
        File file = new File(name);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException exception) {
            System.out.println(exception.getCause());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);

        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new String(buffer);
    }
}
