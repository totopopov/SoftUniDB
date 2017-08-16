package NativeJDBCE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Velislava on 13.7.2017 г..
 */
public class p7_PrintAllMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {

        String query = "SELECT name FROM minions;";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            List<String> names = new ArrayList<>();
            while(rs.next()) {
                String name = rs.getString("name");
                names.add(name);
            }


                for (int i = 0; i < names.size() / 2; i++) {
                    System.out.println(names.get(i));
                    System.out.println(names.get(names.size() - 1 - i));
                }
                if (names.size() % 2 != 0) {
                    System.out.println(names.get(names.size() / 2));
                }


        }
    }
}
