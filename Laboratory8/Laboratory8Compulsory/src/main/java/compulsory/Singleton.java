package compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    private static final String URL = "jdbc:mysql://localhost:3306/laborator8PA";
    private static final String USER = "root";
    private static final String PASSWORD = "valeriacotruta";
    private static Connection connection = null;

    private Singleton() {
    }

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public static void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connecting to the Database
            //A connection is represented by an object of type java.sql.Connection
            connection = getConnection();
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException|SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
    public static void rollback() {
        try {
            connection.setAutoCommit(false);//no rollback autocommit set on true
            connection.rollback();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}