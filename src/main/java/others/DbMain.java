package others;

import entity.Abonent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbMain {

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


        try (
                Connection connection = DriverManager.getConnection(url, props);
                Statement statement = connection.createStatement()) {
//            @Language("SQL")
            String sql = "SELECT idphonebook, lastname, phone FROM phonebook";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Abonent> abonents = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String number = resultSet.getString(3);
                abonents.add(new Abonent(id, name, number));
            }

            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            DatabaseMetaData dbMetaData = connection.getMetaData();

//            System.out.println("Column count: " + rsMetaData.getColumnCount());
//            System.out.println("Column name: " + rsMetaData.getColumnName(2));
//            System.out.println("Column type: " + rsMetaData.getColumnType(2));
//            System.out.println("Column typename: " + rsMetaData.getColumnTypeName(2));
//            System.out.println("Nullable: " + rsMetaData.isNullable(2));

            System.out.println("Database product name: " + dbMetaData.getDatabaseProductName());
            System.out.println("Database product version: " + dbMetaData.getDatabaseProductVersion());
            System.out.println("User name: " + dbMetaData.getUserName());
            System.out.println("URL: " + dbMetaData.getURL());

//            System.out.println(abonents);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
