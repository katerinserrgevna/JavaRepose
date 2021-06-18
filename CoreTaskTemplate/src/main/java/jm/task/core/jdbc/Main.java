package jm.task.core.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl user = new UserServiceImpl();

        user.createUsersTable();

        user.saveUser("Ivan", "Petrov", (byte) 24);
        user.saveUser("Kate","Kalugiva", (byte) 20);
        user.saveUser("Aleksandr","Kosarev", (byte) 26);
        user.saveUser("Olga","Maleeva", (byte) 23);

        List<User> userList = user.getAllUsers();
        for (User u: userList) {
            System.out.println(u.toString());
        }

        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
