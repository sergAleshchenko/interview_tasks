package patterns.decorator;

/**
 * @author Sergei Aleshchenko
 */
public interface DataSource {
    void writeData(String data);

    String readData();
}
