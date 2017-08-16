package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Todor Popov using Lenovo on 10.7.2017 г. at 16:55.
 */


public final class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/miniHibernateDB?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASSWORD = "9010056467";

    private ConnectionManager(){};

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
