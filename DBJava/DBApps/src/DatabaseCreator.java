import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Todor Popov using Lenovo on 11.7.2017 г. at 21:17.
 */
public final class DatabaseCreator {

    private DatabaseCreator() {
    }

    public static void InitiateDatabase(Connection conn) throws SQLException {

        try(Statement statement=conn.createStatement()){
            String deleteDB="DROP DATABASE IF EXISTS MinionsDB;";

            String createDBsql="CREATE DATABASE IF NOT EXISTS MinionsDB;";

            String useDBsql="USE MinionsDB;";

            String createTableTowns="CREATE TABLE IF NOT EXISTS towns(" +
                    "town_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(30) NOT NULL UNIQUE ," +
                    "country VARCHAR (30) NOT NULL )";

            String createTableMinions="CREATE TABLE IF NOT EXISTS minions( " +
                    "minion_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(30) NOT NULL UNIQUE , " +
                    "age INT NOT NULL, " +
                    "town_id INT, " +
                    "CONSTRAINT fk_town_id_towns FOREIGN KEY (town_id) REFERENCES towns(town_id)) ";

            String createTableVillains="CREATE TABLE IF NOT EXISTS villains(" +
                    "villain_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(30) NOT NULL UNIQUE ," +
                    "evilness_factor ENUM('good', 'bad', 'evil', 'super_evil'))";

            String createTableVillainsMinions="CREATE TABLE IF NOT EXISTS contract(" +
                    "minion_id INT," +
                    "villain_id INT," +
                    "CONSTRAINT PRIMARY KEY (minion_id,villain_id)," +
                    "CONSTRAINT FOREIGN KEY (villain_id) REFERENCES villains(villain_id)," +
                    "CONSTRAINT FOREIGN KEY (minion_id) REFERENCES minions(minion_id))";



            String createCallableSPForAge= "CREATE PROCEDURE udp_add_age(IN id INT)\n" +
                    "BEGIN\n" +
                    "START TRANSACTION;\n" +
                    "\n" +
                    "UPDATE minions AS m \n" +
                    "SET m.age=m.age+1 WHERE m.minion_id=id; \n" +
                    "COMMIT;\n" +
                    "END; \n" ;

            String createFunctionForCaps=    "CREATE FUNCTION udf_cap_first(input VARCHAR(255))\n" +
                    "RETURNS VARCHAR(255)\n" +
                    "\n" +
                    "DETERMINISTIC\n" +
                    "\n" +
                    "BEGIN\n" +
                    "\tDECLARE len INT;\n" +
                    "\tDECLARE i INT;\n" +
                    "\n" +
                    "\tSET len   = CHAR_LENGTH(input);\n" +
                    "\tSET input = LOWER(input);\n" +
                    "\tSET i = 0;\n" +
                    "\n" +
                    "\tWHILE (i < len) DO\n" +
                    "\t\tIF (MID(input,i,1) = ' ' OR i = 0) THEN\n" +
                    "\t\t\tIF (i < len) THEN\n" +
                    "\t\t\t\tSET input = CONCAT(\n" +
                    "\t\t\t\t\tLEFT(input,i),\n" +
                    "\t\t\t\t\tUPPER(MID(input,i + 1,1)),\n" +
                    "\t\t\t\t\tRIGHT(input,len - i - 1)\n" +
                    "\t\t\t\t);\n" +
                    "\t\t\tEND IF;\n" +
                    "\t\tEND IF;\n" +
                    "\t\tSET i = i + 1;\n" +
                    "\tEND WHILE;\n" +
                    "\n" +
                    "\tRETURN input;\n" +
                    "END;";

                   String callableForCaps="CREATE PROCEDURE udp_change_name(IN id INT) \n " +
                    "BEGIN\n" +
                    "START TRANSACTION;\n" +
                    "UPDATE minions AS m \n" +
                    "SET m.name=udf_cap_first(m.name) WHERE m.minion_id=id; \n" +
                    "COMMIT; \n  " +
                    "END; ";


            statement.executeUpdate(deleteDB);
            statement.executeUpdate(createDBsql);
            statement.executeUpdate(useDBsql);
            statement.executeUpdate(createTableTowns);
            statement.executeUpdate(createTableMinions);
            statement.executeUpdate(createTableVillains);
            statement.executeUpdate(createTableVillainsMinions);


            String nativeSQL = conn.nativeSQL(createCallableSPForAge);
            statement.addBatch(nativeSQL);
            statement.executeBatch();
            String function=conn.nativeSQL(createFunctionForCaps);
            statement.addBatch(function);
            statement.executeBatch();
            String procedureCaps=conn.nativeSQL(callableForCaps);
            statement.addBatch(procedureCaps);
            statement.executeBatch();



            System.out.println("DATA created Succefully ! ");


            String insertDataIntoTowns="INSERT INTO towns(name,country)" +
                    "VALUE ('Blagoevgrad','Bulgaria')," +
                    "('Sofia','Bulgaria')," +
                    "('Uppsala','Sweden')," +
                    "('Lisboa','Portugal')," +
                    "('Flint MI','USA')";

            String insertDataIntoMinions="INSERT INTO minions(name,age,town_id)" +
                    "VALUE ('Todor','5','1')," +
                    "('Katrin','6','2')," +
                    "('Trifon','7','3')," +
                    "('Ivan','8','4')," +
                    "('Dr.Evel','3','5')," +
                    "('BabyBoss','2','1')";

            String insertDataIntoVillains="INSERT INTO minionsdb.villains(name, evilness_factor) " +
                    "VALUES('Atacama','good')," +
                    "('Motoko','good')," +
                    "('Koze','super_evil')," +
                    "('Jack Bauer','good')," +
                    "('Thanos','evil')";

            String insertDataIntoContract = "INSERT INTO contract()" +
                    "SELECT a.minion_id ,v.villain_id FROM minionsdb.minions AS `a`" +
                    "INNER JOIN minionsdb.villains AS `v` ";


            statement.executeUpdate(insertDataIntoTowns);
            statement.executeUpdate(insertDataIntoMinions);
            statement.executeUpdate(insertDataIntoVillains);
            statement.executeUpdate(insertDataIntoContract);


            System.out.println("Data Insertion Successful !");

            System.out.println("DataBASE is Fresh");


        }
    }
}
