package others;

import entity.Abonent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionDemo {

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
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            ResultSet resultSet = statement.executeQuery(
                    "SELECT idphonebook, lastname, phone FROM phonebook");

            List<Abonent> list = new ArrayList<>();

            // insert row
            resultSet.moveToInsertRow();
            resultSet.updateInt(1, 88);
            resultSet.updateString(2, "Jackson");
            resultSet.updateString(3, "550055");
            resultSet.insertRow();
            resultSet.moveToCurrentRow();

            while (resultSet.next()) {
                // update row
                int id = resultSet.getInt(1);
                if (id == 11) {
                    resultSet.updateString("phone", "770077");
                    resultSet.updateRow();
                }

                list.add(new Abonent(
                        id,
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }

            if (!list.isEmpty()) {
                System.out.println(list);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
