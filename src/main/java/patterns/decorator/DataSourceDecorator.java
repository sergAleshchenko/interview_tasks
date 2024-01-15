package patterns.decorator;

import lombok.AllArgsConstructor;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
public class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
