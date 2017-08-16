package NativeJDBCE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Velislava on 12.7.2017 г..
 */
public class p1_InitialSetup {
    private static final String URL = "jdbc:mysql://localhost:3306/";

    private static final String USER = "root";

    private static final String PASSWORD = "9010056467";

    public static void main(String[] args) throws SQLException {
        String createQuery = "CREATE DATABASE minions_db;";
        String useQuery = "USE minions_db;";

        String createMinionTableQuery = "CREATE TABLE minions(" +
                "minion_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "age INT, " +
                "town_id INT, " +
                "CONSTRAINT fk_minions_towns " +
                "FOREIGN KEY (town_id) " +
                "REFERENCES towns(town_id));";
        String createTownsTableQuery = "CREATE TABLE towns( " +
                "town_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(20), " +
                "country VARCHAR(20));";
        String createVillainsTableQuery = "CREATE TABLE villains(" +
                "villain_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "evilness VARCHAR(20))";
        String createVillainsMinionsTbableQuery = "CREATE TABLE villains_minions( " +
                "minion_id INT, " +
                "villain_id INT, " +
                "CONSTRAINT pk_villains_minions " +
                "PRIMARY KEY(minion_id, villain_id), " +
                "CONSTRAINT fk_villains_minions_minions " +
                "FOREIGN KEY(minion_id) " +
                "REFERENCES minions(minion_id), " +
                "CONSTRAINT fk_villains_minions_villains " +
                "FOREIGN KEY(villain_id) " +
                "REFERENCES villains(villain_id));";

        String insertIntoMinionsQuery = "INSERT INTO minions (name, age, town_id)\n" +
                "VALUES (\"Bob\", 21, 1), (\"Kevin\", 15, 5), (\"Steward\", 28, 3), (\"Simon\", 2, 4), (\"Roger\", 7, 2);";
        String insertIntoTownsQuery = "INSERT INTO towns (name, country)\n" +
                "VALUES (\"Berlin\", \"Germany\"), (\"Plovdiv\", \"Bulgaria\"), (\"Sofia\", \"Bulgaria\"), (\"London\", \"Great Britain\"), (\"Stockholm\", \"Sweden\");";
        String insertIntoVillainsQuery = "INSERT INTO villains (name, evilness)\n" +
                "VALUES (\"Gru\", \"evil\"), (\"Victor\", \"super evil\"), (\"Naskata\", \"good\"), (\"Grigor\", \"bad\"), (\"Gena\", \"bad\");";
        String insertIntoVillainsMinionsQuery = "INSERT INTO villains_minions (minion_id, villain_id)\n" +
                "VALUES (1, 1), (1, 2), (1, 3), (2, 4), (2, 2), (2, 3), (3, 1), (3, 5), (4, 5), (4, 4), (4, 3), (5, 5), (5, 4), (5, 2), (5, 1)," +
                "(1, 5), (2, 5), (1, 4);";


        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createQuery);
            statement.executeQuery(useQuery);
            statement.executeUpdate(createTownsTableQuery);
            statement.executeUpdate(createMinionTableQuery);
            statement.executeUpdate(createVillainsTableQuery);
            statement.executeUpdate(createVillainsMinionsTbableQuery);

            statement.executeUpdate(insertIntoTownsQuery);
            statement.executeUpdate(insertIntoMinionsQuery);
            statement.executeUpdate(insertIntoVillainsQuery);
            statement.executeUpdate(insertIntoVillainsMinionsQuery);

        }

    }
}
