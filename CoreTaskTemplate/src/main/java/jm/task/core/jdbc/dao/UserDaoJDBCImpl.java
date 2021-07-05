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

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();

            String SQL = "CREATE TABLE IF NOT EXISTS  User " +
                    "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " name text NOT NULL, " +
                    " lastName text NOT NULL, " +
                    " age TINYINT NOT NULL)";

            statement.executeUpdate(SQL);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void dropUsersTable() {
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();

            String SQL = "DROP TABLE IF EXISTS  User";
            statement.executeUpdate(SQL);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();

            String SQL= "INSERT INTO User(name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";
            statement.executeUpdate(SQL);
            connection.close();

            System.out.println("User с именем - " + name + " добавлен в таблицу.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void removeUserById(long id) {
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();

            String SQL = "DELETE FROM User WHERE id = " + id;
            statement.executeUpdate(SQL);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> getAllUsers() {
        try {
            User user;
            List<User> userList = new ArrayList<>();

            Connection connection = Util.getConnection();
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
            connection.close();

            return userList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void cleanUsersTable() {
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();

            String SQL = "TRUNCATE TABLE User";
            statement.executeUpdate(SQL);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
