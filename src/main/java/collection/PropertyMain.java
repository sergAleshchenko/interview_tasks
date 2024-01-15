package collection;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyMain {
    public static void main(String[] args) throws IOException {
        PropertyLoader loader = new PropertyLoader();

        Properties properties = loader.loadFile("message.properties");
        properties.list(System.out);
        properties.put("button", "Button_B");

        String label = (String) properties.get("label");
        String valueDefault = properties.getProperty("xyz", "defaultValue");


        System.out.println(label);
        System.out.println(valueDefault);


        properties.store(new FileWriter("logs/message.properties"), "Comment Prop");
    }
}
