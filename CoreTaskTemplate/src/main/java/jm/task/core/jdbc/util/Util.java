package jm.task.core.jdbc.util;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/javaDB?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "89811582990Kate";
    Connection connection = null;
    Statement statement = null;

    public Util() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

        } catch (SQLException e) {
            System.out.println("Error...");
        }

    }

    public Statement getStatement(){
        return statement;
    }

    public void closeConnection() {
        try{
            if (connection != null) {
                connection.close();
                connection = null;

                System.out.println("Connection is closed..");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
