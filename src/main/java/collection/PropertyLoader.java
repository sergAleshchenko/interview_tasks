package collection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    public Properties loadFile(String filename) {
        Properties properties = new Properties();
        properties.put("submit", "Submit_A");

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
