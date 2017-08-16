import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Todor Popov using Lenovo on 10.7.2017 г. at 14:58.
 */
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASSWORD = "9010056467";

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);) {
            System.out.println("Coonection established successfully");

            System.out.println(connection.getAutoCommit());

            try (Statement statement = connection.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS USERS(" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR (50)," +
                        "password VARCHAR(10)" +
                        ")";
                statement.executeUpdate(sql);
                System.out.println("Table USERS Initialized !");
            }

            {
                try (Statement statement = connection.createStatement()) {
//                    String sql = "INSERT INTO USERS(name,password)" +
//                            "VALUES('Motoko','shell'),('Koze','ghost')";
//                    int affectedRows = statement.executeUpdate(sql);
//                    System.out.println(affectedRows+" rows inserted !");
                }
            }

        }
    }

    public static boolean login(Connection conne,String username, String password) {


        return true;
    }

}

