package NativeJDBCE;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Velislava on 12.7.2017 г..
 */
public class p4_AddMinion {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        String[] minionInfo = sc.nextLine().split("\\s+");
        String minionName = minionInfo[1];
        Integer minionAge = Integer.parseInt(minionInfo[2]);
        String townName = minionInfo[3];

        String[] villainInfo = sc.nextLine().split("\\s+");
        String villainName = villainInfo[1];

        String selectTownQuery = "SELECT * FROM towns " +
                "WHERE name=?";
        String selectVillainQuery = "SELECT * FROM villains " +
                "WHERE name=?";
        String selectMinionQuery = "SELECT * FROM minions WHERE name = ?";
        String insertTownQuery = "INSERT INTO towns(name) VALUE(?)";
        String insertVillainQuery = "INSERT INTO villains(name, evilness) VALUE(?, 'evil')";

        String insertMinionQuery = "INSERT INTO minions(name, age, town_id) VALUE (?, ?, ?)";
        String insertIntoMapTable = "INSERT INTO villains_minions(minion_id, villain_id) VALUE(?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement townStatement = connection.prepareStatement(selectTownQuery);
            townStatement.setString(1, townName);
            ResultSet townResult = townStatement.executeQuery();

            if (!townResult.next()) {
                PreparedStatement insertTownStatement = connection.prepareStatement(insertTownQuery);
                insertTownStatement.setString(1, townName);
                insertTownStatement.executeUpdate();
                System.out.printf("Town %s was added to the database.\n", townName);
                insertTownStatement.close();
            }
            int townId = 0;
            ResultSet townResultUpdated = townStatement.executeQuery();
            if (townResultUpdated.next()) {
                townId = townResultUpdated.getInt("town_id");
            }
            townStatement.close();

            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setString(1, villainName);
            ResultSet villainResult = selectVillainStatement.executeQuery();

            if (!villainResult.next()) {
                PreparedStatement insertVillainStatement = connection.prepareStatement(insertVillainQuery);
                insertVillainStatement.setString(1, villainName);
                insertVillainStatement.executeUpdate();
                System.out.println("Villain " + villainName + " was added to the database.");
                insertVillainStatement.close();
            }

            int villainId = 0;
            ResultSet villainResultUpdated = selectVillainStatement.executeQuery();
            if (villainResultUpdated.next()) {
                villainId = villainResultUpdated.getInt("villain_id");
            }
            selectVillainStatement.close();

            PreparedStatement insertMinionStatement = connection.prepareStatement(insertMinionQuery);
            insertMinionStatement.setString(1, minionName);
            insertMinionStatement.setInt(2, minionAge);
            insertMinionStatement.setInt(3, townId);
            insertMinionStatement.executeUpdate();

            insertMinionStatement.close();

            PreparedStatement selectMinionStatement = connection.prepareStatement(selectMinionQuery);
            selectMinionStatement.setString(1, minionName);
            ResultSet selectMinionResult = selectMinionStatement.executeQuery();
            int minionId = 0;
            if (selectMinionResult.next()) {
                minionId = selectMinionResult.getInt("minion_id");
            }

            selectMinionStatement.close();

            PreparedStatement insertMapTableStatement = connection.prepareStatement(insertIntoMapTable);
            insertMapTableStatement.setInt(1, minionId);
            insertMapTableStatement.setInt(2, villainId);
            insertMapTableStatement.executeUpdate();

            System.out.printf("Successfully added %s to be minion of %s\n", minionName, villainName);
        }
    }
}
