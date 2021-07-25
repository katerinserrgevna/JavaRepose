package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    static private Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Statement statement = connection.createStatement();

            String SQL = "CREATE TABLE IF NOT EXISTS  User " +
                    "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " name text NOT NULL, " +
                    " lastName text NOT NULL, " +
                    " age TINYINT NOT NULL)";

            statement.executeUpdate(SQL);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void dropUsersTable() {
        try {
            Statement statement = connection.createStatement();

            String SQL = "DROP TABLE IF EXISTS  User";
            statement.executeUpdate(SQL);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        try {
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO User(name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")");

            connection.commit();

            statement.close();
            System.out.println("User с именем - " + name + " добавлен в таблицу.");
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

    }

    @Override
    public void removeUserById(long id) throws SQLException {
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM User WHERE id = " + id);
            connection.commit();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

    }

    @Override
    public List<User> getAllUsers() {
        try {
            User user;
            List<User> userList = new ArrayList<>();
            Statement statement = connection.createStatement();

            String SQL = "SELECT * FROM User";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));

                userList.add(user);
            }
            statement.close();

            return userList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void cleanUsersTable() {
        try {
            Statement statement = connection.createStatement();

            String SQL = "TRUNCATE TABLE User";
            statement.executeUpdate(SQL);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}