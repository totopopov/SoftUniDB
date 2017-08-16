package NativeJDBCE;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Velislava on 12.7.2017 г..
 */
public class p3_GetMinionsName {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {

        String query = "SELECT v.name AS villain_name, m.name AS min_name, m.age\n" +
                "FROM villains v\n" +
                "JOIN villains_minions vm\n" +
                "ON v.villain_id = vm.villain_id\n" +
                "JOIN minions m\n" +
                "ON m.minion_id = vm.minion_id\n" +
                "WHERE v.villain_id = ?;";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please insert id here: ");
            int id = Integer.parseInt(sc.nextLine());
            stmt.setInt(1, id);
            try {
                ResultSet rs = stmt.executeQuery();
                rs.next();
                String villainName = rs.getString("villain_name");
                System.out.print("Villain: ");
                System.out.println(villainName);
                int num = 1;
                String minionName = rs.getString("min_name");
                int minAge = rs.getInt("age");
                System.out.println(num + ". " + minionName + " " + minAge);

                while (rs.next()) {
                    num++;
                    minionName = rs.getString("min_name");
                    minAge = rs.getInt("age");
                    System.out.println(num + ". " + minionName + " " + minAge);
                }


            }
            catch(SQLException e) {
                System.out.println("No villain with ID " + id + " exists in the database.");
            }
        }
    }
}
