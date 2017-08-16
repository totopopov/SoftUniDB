import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 17.7.2017 г. at 20:27.
 */
public final class ChangeTownNames {

    private ChangeTownNames() {
    }
    public static void getNames(Connection conn, String country) throws SQLException {

        String getNamesSql="UPDATE minionsdb.towns AS `t` " +
                "SET t.name=UPPER(t.name) WHERE t.country=?";
        String getChangedTownsSql="SELECT t.name as `towns` FROM minionsdb.towns AS `t` " +
                "WHERE t.country=?";

        int result=0;

        try(PreparedStatement changeTowns=conn.prepareStatement(getNamesSql)){


            changeTowns.setString(1,country);

            result = changeTowns.executeUpdate();

            boolean foundNoNames=true;
            List<String> towns=new LinkedList<>();


            if (result==0){
                System.out.println("No town names were affected.");
            } else {

                try (PreparedStatement getTowns=conn.prepareStatement(getChangedTownsSql)){
                    getTowns.setString(1,country);

                    ResultSet changedTowns=getTowns.executeQuery();

                    while (changedTowns.next()){
                        String town=changedTowns.getString("towns");
                        towns.add(town);
                    }

                    if (towns.size()==result){
                        System.out.println(String.format("%d town names were affected.",result));
                        System.out.println(towns);
                    }else {
                        System.out.println("an error occured, contact Todor for support");
                    }
                }


            }

        }
    }


}
