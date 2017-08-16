package NativeJDBCE;

import java.sql.*;

/**
 * Created by Velislava on 12.7.2017 г..
 */
public class p2_GetVillainsNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {

        String selectFromVillainsTable = "SELECT v.name, COUNT(vm.minion_id) AS minioins_count FROM villains v \n" +
                "JOIN villains_minions vm \n" +
                "ON v.villain_id = vm.villain_id\n" +
                "GROUP BY vm.villain_id\n" +
                "HAVING minioins_count > 3\n" +
                "ORDER BY minioins_count DESC;";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(selectFromVillainsTable);
            while (rs.next()) {
                String name = rs.getString("name");
                int mins_count = rs.getInt("minioins_count");
                System.out.println(name + " " + mins_count);
            }
        }
    }
}
