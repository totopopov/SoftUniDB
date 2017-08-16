import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;

/**
 * Created by Todor Popov using Lenovo on 17.7.2017 г. at 23:20.
 */
public final class Capitalize {
    private Capitalize() {
    }

    public static void capitalizeName(Connection conn, int minionId) throws SQLException {


        String changeName = "CALL udp_change_name(?)";

        ArrayDeque<String> minionNames = new ArrayDeque<>();

        try (CallableStatement addAge = conn.prepareCall(changeName)) {

            addAge.setInt(1,minionId);

            addAge.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
