import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Todor Popov using Lenovo on 11.7.2017 г. at 21:19.
 */
public final class AddMinions {

    private AddMinions() {}

    public static void getNames(Connection conn,String villainName,String townName,String minionName,String age) throws SQLException {

        String getVillainSql="SELECT v.villain_id AS `id` FROM minionsdb.villains AS `v` " +
                "WHERE v.name=?";

        String getTownsSql="SELECT t.town_id AS `id` FROM minionsdb.towns AS `t` " +
                "WHERE t.name=?";

        String getMInionSql="SELECT m.minion_id AS `id` FROM minionsdb.minions AS `m` " +
                "WHERE m.name=?";

        Integer villainId=GetIntBySql.getInt(conn,villainName,getVillainSql);
        Integer townId=GetIntBySql.getInt(conn,townName,getTownsSql);
        Integer minionId=GetIntBySql.getInt(conn,minionName,getMInionSql);
        conn.setAutoCommit(false);

        //starting transaction
        try {

            if (townId == null) {
                String insertIntoTown = "INSERT INTO minionsdb.towns(name, country)" +
                        "VALUE(?,'N/A')";

                try (PreparedStatement insertTown = conn.prepareStatement(insertIntoTown)) {

                    insertTown.setString(1, townName);
                    insertTown.executeUpdate();
                    System.out.println(String.format("Town %s was added to the database.", townName));
                    townId = GetIntBySql.getInt(conn, townName, getTownsSql);
                }
            }

            if (villainId == null) {
                String insertIntoVillain = "INSERT INTO minionsdb.villains(name, evilness_factor) " +
                        "VALUE(?,'evil')";

                try (PreparedStatement insertVillain = conn.prepareStatement(insertIntoVillain)) {

                    insertVillain.setString(1, villainName);
                    insertVillain.executeUpdate();
                    System.out.println(String.format("Villain %s was added to the database.", villainName));
                    villainId = GetIntBySql.getInt(conn, villainName, getVillainSql);
                }
            }

            if (minionId == null) {
                String insertIntoMinion = "INSERT INTO minionsdb.minions(name, age, town_id)" +
                        "VALUE(?,?,?)";

                try (PreparedStatement insertMinion = conn.prepareStatement(insertIntoMinion)) {

                    insertMinion.setString(1, minionName);
                    insertMinion.setInt(2, Integer.parseInt(age));
                    insertMinion.setInt(3, townId);
                    insertMinion.executeUpdate();
                    minionId = GetIntBySql.getInt(conn, minionName, getMInionSql);
                }
            }

            if (minionId != null && villainId != null) {

                String insertIntoContract = "INSERT INTO minionsdb.contract()" +
                        "VALUE(?,?)";

                try (PreparedStatement getVillainId = conn.prepareStatement(insertIntoContract)) {

                    getVillainId.setInt(1, minionId);
                    getVillainId.setInt(2, villainId);
                    getVillainId.executeUpdate();
                    System.out.println(String.format("Successfully added %s to be minion of %s", minionName, villainName));
                    GetIntBySql.getInt(conn, villainName, getVillainSql);
                }
            }

            conn.commit();
        }catch (SQLException e){
          conn.rollback();
            System.out.println(e.getMessage());
        }

        //transaction END
        conn.setAutoCommit(true);

    }


}
