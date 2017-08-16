package NativeJDBCE;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Velislava on 13.7.2017 г..
 */
public class p8_IncreaseMinionsAge {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";

    private static final String USER = "root";

    private static final String PASSWORD = "9010056467";

    public static void main(String[] args) throws SQLException {

        String selectQuery = "SELECT name, age FROM minions WHERE minion_id = ?";
        String updateQuery = "UPDATE minions SET name = ?, age = age + 1 WHERE minion_id = ?";
        String selectAll = "SELECT name, age FROM minions";
        Scanner scanner = new Scanner(System.in);
        String[] ids = scanner.nextLine().split("\\s+");
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            for (int i = 0; i < ids.length; i++) {
                Integer id = Integer.parseInt(ids[i]);
                PreparedStatement selectMinionStatement = connection.prepareStatement(selectQuery);
                selectMinionStatement.setInt(1, id);
                ResultSet selectMinionResult = selectMinionStatement.executeQuery();
                selectMinionResult.next();
                String minionName = selectMinionResult.getString("name");
                String futureName = toDisplayCase(minionName);

                PreparedStatement updateMinionStatement = connection.prepareStatement(updateQuery);
                updateMinionStatement.setString(1, futureName);
                updateMinionStatement.setInt(2, id);
                updateMinionStatement.executeUpdate();

                selectMinionStatement.close();
                updateMinionStatement.close();
            }

            PreparedStatement selectAllStatement = connection.prepareStatement(selectAll);
            ResultSet rs = selectAllStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                System.out.println(name + " " + age);
            }


        }
    }

    public static String toDisplayCase(String s) {

        final String ACTIONABLE_DELIMITERS = " '-/"; // these cause the character following
        // to be capitalized

        StringBuilder sb = new StringBuilder();
        boolean capNext = true;

        for (char c : s.toCharArray()) {
            c = (capNext)
                    ? Character.toUpperCase(c)
                    : Character.toLowerCase(c);
            sb.append(c);
            capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0); // explicit cast not needed
        }
        return sb.toString();
    }

}
