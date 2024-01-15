package others;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class BatchMain {

    public static void insertions(String url, Properties props) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, props);
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.addBatch("INSERT INTO phonebook VALUES (15, 'Bagdanovich', '112211')");
            statement.addBatch("INSERT INTO location VALUES (201, 'Karaganda')");
            statement.addBatch("INSERT INTO location VALUES (202, 'Lviv')");
            int[] updateCounts = statement.executeBatch();
            connection.commit();
            System.out.println(Arrays.toString(updateCounts));
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.put("user", "postgres");
        props.put("password", "admin1234");
        props.put("autoReconnect", "true");
        props.put("characterEncoding", "UTF-8");
        props.put("useUnicode", "true");
        props.put("useSSL", "true");

        insertions(url, props);
    }
}
