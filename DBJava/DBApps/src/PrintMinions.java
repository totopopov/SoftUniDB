import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Map;

/**
 * Created by Todor Popov using Lenovo on 17.7.2017 г. at 22:05.
 */
public final class PrintMinions {

    private PrintMinions() {
    }

    public static void print(Connection conn, String type,Integer id) throws SQLException {


        String findAllMinions = "SELECT m.name,m.age FROM minionsdb.minions AS `m` ";
        String findOneMinions = "SELECT m.name,m.age FROM minionsdb.minions AS `m` WHERE minion_id=? ";

        ArrayDeque<String> minionNames = new ArrayDeque<>();
        ArrayDeque<Integer> minionAge = new ArrayDeque<>();



        //Some major bad CODE
        try (PreparedStatement printMinions = conn.prepareStatement(id==null?findAllMinions:findOneMinions)) {

            if (id!=null){
                         printMinions.setInt(1,id);
            }
            ResultSet minions = printMinions.executeQuery();


            while (minions.next()) {
                minionNames.offer(minions.getString("name"));
                minionAge.offer(minions.getInt("age"));
            }

        }

        while (!minionNames.isEmpty()) {
            //just for the sake of it ===>
            System.out.println(type.equals("fuzzy")?minionNames.pop():String.format("%s %d",minionNames.pop(),minionAge.pop()));
            if (!minionNames.isEmpty() && type.equals("fuzzy")) {
                System.out.println(minionNames.removeLast());
            }
        }


    }
}
