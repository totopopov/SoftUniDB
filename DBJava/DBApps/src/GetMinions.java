import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Todor Popov using Lenovo on 11.7.2017 г. at 21:19.
 */
public final class GetMinions {

    private GetMinions() {
    }

    public static void getMinions(Connection conn, int villanId) throws SQLException {
        String getMinionsSql="SELECT v.name as `vn`, m.name as `mn`, m.age FROM minionsdb.villains AS `v`" +
                "LEFT JOIN  minionsdb.contract AS `c` ON v.villain_id=c.villain_id " +
                "LEFT JOIN  minionsdb.minions AS `m` ON m.minion_id=c.minion_id " +
                "WHERE v.villain_id=? " +
                "ORDER BY m.name,m.age";

        try(PreparedStatement getMinions=conn.prepareStatement(getMinionsSql)){


            getMinions.setInt(1,villanId);

            ResultSet minions = getMinions.executeQuery();

            boolean foundNoVillians=true;
            boolean printVillianName=false;
            int counter=1;

            while(minions.next()){

                foundNoVillians=false;
                if (!printVillianName){
                    String villainName=minions.getString("vn");
                    System.out.println(String.format("Villain: %s",villainName));
                }

                String minionName=minions.getString("mn");
                Integer minionage=minions.getInt("age");

                if (minionName!=null && minionage!=null){
                    System.out.println(String.format("%d. %s %d",counter,minionName,minionage));
                }else if (!printVillianName){
                    System.out.println("<no minions>....Sad");
                }


                counter++;
                printVillianName=true;
            }



            if (foundNoVillians){
                System.out.println(String.format("No villain with ID %d exists in the database.",villanId));
            }

        }
    }
}
