package optional;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionPool {
    private static final String URL = "jdbc:mysql://localhost:3306/laborator8PA";
    private static final String USER = "root";
    private static final String PASSWORD = "valeriacotruta";
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(10);
        return dataSource;
    }

    public Connection getConnection() {
        try {
            Connection connection = null;

            DataSource dataSource = getDataSource();

            connection = dataSource.getConnection();

            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}