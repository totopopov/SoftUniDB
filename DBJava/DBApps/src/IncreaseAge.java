import java.sql.*;
import java.util.ArrayDeque;

/**
 * Created by Todor Popov using Lenovo on 17.7.2017 г. at 23:20.
 */
public final class IncreaseAge {
    private IncreaseAge() {
    }

    public static void getOlder(Connection conn, int minionId) throws SQLException {


        String increaseTheAge = "CALL udp_add_age(?)";

        ArrayDeque<String> minionNames = new ArrayDeque<>();

        try (CallableStatement addAge = conn.prepareCall(increaseTheAge)) {

            addAge.setInt(1,minionId);

            addAge.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
