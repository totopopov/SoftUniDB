import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Todor Popov using Lenovo on 13.7.2017 г. at 19:32.
 */
public final class GetStringBySql {

    private GetStringBySql() {}

    public static String getString(Connection conn, int id, String getNamesSql) throws SQLException {
        String result;
        try(PreparedStatement getEntityName=conn.prepareStatement(getNamesSql)){

            getEntityName.setInt(1, id);
            ResultSet villain = getEntityName.executeQuery();

            if (villain.next()){
                result=villain.getString(1);
                return result;
            }
            return null;
        }
    }
}
