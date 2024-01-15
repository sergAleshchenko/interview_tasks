package dao.impl;

import dao.AbonentDao;
import dao.DaoException;
import entity.Abonent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



public class AbonentDaoImpl implements AbonentDao {
    private static final String SQL_SELECT_ALL_ABONENTS = "SELECT idphonebook, lastname, phone FROM phonebook";
    private static final String SQL_SELECT_ABONENT_BY_LASTNAME = "SELECT idphonebook, lastname, phone FROM phonebook WHERE lastname=?";



    @Override
    public List<Abonent> findAbonentByLastname(String namePattern) throws DaoException {
        List<Abonent> abonents = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        Properties props = new Properties();
        props.put("user", "postgres");
        props.put("password", "admin1234");
        props.put("autoReconnect", "true");
        props.put("characterEncoding", "UTF-8");
        props.put("useUnicode", "true");
        props.put("useSSL", "true");

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", props);
            statement = connection.prepareStatement(SQL_SELECT_ABONENT_BY_LASTNAME);
            statement.setString(1, namePattern);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Abonent abonent = new Abonent();
                abonent.setId(resultSet.getInt("idphonebook"));
                abonent.setPhone(resultSet.getString("phone"));
                abonent.setName(resultSet.getString("lastname"));
                abonents.add(abonent);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }

        return abonents;
    }

    @Override
    public List<Abonent> findAll() {
        List<Abonent> abonents = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        Properties props = new Properties();
        props.put("user", "postgres");
        props.put("password", "admin1234");
        props.put("autoReconnect", "true");
        props.put("characterEncoding", "UTF-8");
        props.put("useUnicode", "true");
        props.put("useSSL", "true");

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", props);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ABONENTS);
            while (resultSet.next()) {
                Abonent abonent = new Abonent();
                abonent.setId(resultSet.getInt("idphonebook"));
                abonent.setPhone(resultSet.getString("phone"));
                abonent.setName(resultSet.getString("lastname"));
                abonents.add(abonent);
            }
        } catch (SQLException e) {
            System.err.println("SQLException (request or table failed): " + e);
        } finally {
            close(statement);
            close(connection);
        }

        return abonents;
    }

    @Override
    public Abonent findEntity(Long id) {
        return null;
    }

    @Override
    public boolean delete(Abonent abonent) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Abonent abonent) {
        return false;
    }

    @Override
    public Abonent update(Abonent abonent) {
        return null;
    }
}
