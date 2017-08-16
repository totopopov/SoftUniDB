import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Todor Popov using Lenovo on 11.7.2017 г. at 21:19.
 */
public class GetNames {

    private GetNames() {
    }

    public static void getNames(Connection conn,int countMinions) throws SQLException {
        String getNamesSql="SELECT V.name, count(c.minion_id) AS `count` FROM minionsdb.minions AS `V` " +
                "INNER JOIN minionsdb.contract AS `c` " +
                "GROUP BY V.name " +
                "HAVING count>? " +
                "ORDER BY count DESC ";

        try(PreparedStatement getNames=conn.prepareStatement(getNamesSql)){


            getNames.setInt(1,countMinions);

            ResultSet names = getNames.executeQuery();

            boolean foundNoNames=true;

            while(names.next()){

                foundNoNames=false;
                String name=names.getString("name");
                int count =names.getInt("count");
                System.out.println(String.format("%s %d",name,count));
            }



            if (foundNoNames){
                System.out.println("Sorry no Villains good for this task (:");
            }

        }
    }
}
