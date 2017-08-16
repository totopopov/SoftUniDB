package NativeJDBCE;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Velislava on 13.7.2017 г..
 */
public class p9_CallProcedure {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";

    private static final String USER = "root";

    private static final String PASSWORD = "9010056467";

    public static void main(String[] args) throws SQLException {
        System.out.println("Please insert id of minion here: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        String selectMinion = "SELECT name, age FROM minions WHERE minion_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String procedure = "CALL usp_get_older(?)";
            try(CallableStatement callableStatement = connection.prepareCall(procedure)) {
                callableStatement.setInt(1, id);
                callableStatement.execute();

                PreparedStatement stmt = connection.prepareStatement(selectMinion);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                System.out.print(rs.getString("name"));
                System.out.println(" " + rs.getInt("age"));

                stmt.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
