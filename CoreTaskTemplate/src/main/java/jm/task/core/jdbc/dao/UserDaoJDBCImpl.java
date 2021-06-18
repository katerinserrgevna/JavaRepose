package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private Util util = new Util();
    private Statement statement = util.getStatement();

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            String SQL = "CREATE TABLE IF NOT EXISTS  User " +
                    "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " name text NOT NULL, " +
                    " lastName text NOT NULL, " +
                    " age TINYINT NOT NULL)";

            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void dropUsersTable() {
        try {
            String SQL = "DROP TABLE IF EXISTS  User";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            String SQL= "INSERT INTO User(name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";
            statement.executeUpdate(SQL);

            System.out.println("User с именем - " + name + " добавлен в таблицу.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void removeUserById(long id) {
        try {
            String SQL = "DELETE FROM User WHERE id = " + id;
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> getAllUsers() {
        try {
            User user;
            List<User> userList = new ArrayList<>();

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

            return userList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void cleanUsersTable() {
        try {
            String SQL = "TRUNCATE TABLE User";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
