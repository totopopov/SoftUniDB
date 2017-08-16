import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Todor Popov using Lenovo on 13.7.2017 г. at 19:32.
 */
public final class GetIntBySql {

    private GetIntBySql() {}

    public static Integer getInt(Connection conn, String NameForID, String getNamesSql) throws SQLException {
        Integer result;
        try(PreparedStatement getVillainId=conn.prepareStatement(getNamesSql)){

            getVillainId.setString(1, NameForID);
            ResultSet villain = getVillainId.executeQuery();

            if (villain.next()){
                result=villain.getInt("id");
                return result;
            }
            return null;
        }
    }
}
