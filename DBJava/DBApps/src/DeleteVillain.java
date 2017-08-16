import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Todor Popov using Lenovo on 17.7.2017 г. at 21:34.
 */
public final class DeleteVillain {

    private DeleteVillain() {
    }

    public static void headShoot(Connection conn, int villainId) throws SQLException {

        //start Transaction
        conn.setAutoCommit(false);
        try {
            String deleteAndReleaseMinions = "DELETE c FROM minionsdb.contract AS `c` " +
                    "WHERE c.villain_id=?";

            String shootVillianInTheHead = "DELETE FROM minionsdb.villains WHERE villain_id=?";

            String getVillians = "SELECT v.name FROM minionsdb.villains as `v` WHERE villain_id=? ";

            int releasedM = 0;
            int deletedV = 0;

            try (PreparedStatement releaseMinions = conn.prepareStatement(deleteAndReleaseMinions)) {
                releaseMinions.setInt(1, villainId);

                releasedM = releaseMinions.executeUpdate();
            }

            String villainName = GetStringBySql.getString(conn, villainId, getVillians);

            try (PreparedStatement assasinateVillian = conn.prepareStatement(shootVillianInTheHead)) {

                assasinateVillian.setInt(1, villainId);
                deletedV = assasinateVillian.executeUpdate();

            }

            if (deletedV == 0) {
                System.out.println(String.format("No such villain was found"));
            } else {
                System.out.println(String.format("%s was assasinated...I mean deleted from table", villainName));

                System.out.println(String.format("%d minions were released",releasedM));

            }

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            System.out.println(e.getMessage());
        }
        //endTransaction Transaction
        conn.setAutoCommit(true);
    }
}
