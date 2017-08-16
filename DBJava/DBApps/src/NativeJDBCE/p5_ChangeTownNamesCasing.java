package NativeJDBCE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Velislava on 12.7.2017 г..
 */
public class p5_ChangeTownNamesCasing {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {

        String updateTownsQuery = "UPDATE towns t\n" +
                "SET t.name = UCASE(t.name)\n" +
                "WHERE t.country =?;";
        String selectTownsQuery = "SELECT t.name FROM towns t WHERE t.country=?";
        System.out.println("Please insert name of country here: ");
        Scanner sc = new Scanner(System.in);
        String country = sc.nextLine();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement updateTownsStatement = connection.prepareStatement(updateTownsQuery);
            updateTownsStatement.setString(1, country);
            int affectedRows = updateTownsStatement.executeUpdate();
            if (affectedRows > 0) {
                PreparedStatement selectTownsStatement = connection.prepareStatement(selectTownsQuery);
                selectTownsStatement.setString(1, country);
                ResultSet selectTownsResult = selectTownsStatement.executeQuery();
                List<String> towns = new ArrayList<>();
                while (selectTownsResult.next()) {
                    String town = selectTownsResult.getString("name");
                    towns.add(town);
                }
                System.out.println(affectedRows + " town names were affected. ");
                System.out.println(towns);
                selectTownsStatement.close();
            }
            else
                System.out.println("No town names were affected.");
            updateTownsStatement.close();

        }


    }
}

