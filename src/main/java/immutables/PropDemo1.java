package immutables;

import java.util.Properties;

public class PropDemo1 {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.list(System.out);

    }
}
