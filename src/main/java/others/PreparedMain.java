package others;

import java.sql.*;
import java.util.Properties;

public class PreparedMain {

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


        try (Connection connection = DriverManager.getConnection(url, props)) {
            String sql = "INSERT INTO phonebook(idphonebook, lastname, phone) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 33);
            statement.setString(2, "Kavalski");
            statement.setString(3, "33333333");
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
