package NativeJDBCE;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Velislava on 13.7.2017 г..
 */
public class p6_RemoveVillain {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Integer villainId = Integer.parseInt(scanner.nextLine());
        String deleteMapTabQuery = "DELETE FROM villains_minions WHERE villain_id=?";
        String deleteVillainTable = "DELETE FROM villains WHERE villain_id=?";
        String selectVillain = "SELECT * FROM villains WHERE villain_id=?";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillain);
            selectVillainStatement.setInt(1, villainId);
            ResultSet selectVillainResult = selectVillainStatement.executeQuery();
            if (selectVillainResult.next()) {
                String villainName = selectVillainResult.getString("name");
                PreparedStatement deleteMapStatenet = connection.prepareStatement(deleteMapTabQuery);
                deleteMapStatenet.setInt(1, villainId);
                int affectedRows = deleteMapStatenet.executeUpdate();
                PreparedStatement deleteVillainStatement = connection.prepareStatement(deleteVillainTable);
                deleteVillainStatement.setInt(1, villainId);
                deleteVillainStatement.executeUpdate();

                System.out.println(villainName + " was deleted.");
                System.out.println(affectedRows + " minions released.");

                deleteMapStatenet.close();
                deleteVillainStatement.close();
            }
            else {
                System.out.println("No such villain was found");
            }
            selectVillainStatement.close();
        }
    }
}
