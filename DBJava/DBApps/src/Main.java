import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

/**
 * Created by Todor Popov using Lenovo on 11.7.2017 г. at 18:49.
 */
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/";  //your own port
    private static final String USER = "root";
    private static final String PASSWORD = "9010056467";    //your own password

    public static void main(String[] args) throws SQLException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conection established");

            DatabaseCreator.InitiateDatabase(conn);

            StringBuilder sb = new StringBuilder();

            sb.append("Welcome to the pretty BASIC DB system. Seriosly its limited, but no worries new one is coming...");
            sb.append(System.lineSeparator());
            sb.append("Anyway Here is the MENU:");
            sb.append(System.lineSeparator());
            sb.append("PRESS '1' for getting those VILLAINS names... Muhahah");
            sb.append(System.lineSeparator());
            sb.append("PRESS '2' for getting those MINION names... Muhahah");
            sb.append(System.lineSeparator());
            sb.append("PRESS '3' for adding that MINION... Muhahah");
            sb.append(System.lineSeparator());
            sb.append("PRESS '4' for capitalizing those towns... Muhahah");
            sb.append(System.lineSeparator());
            sb.append("PRESS '5' for decapitating a villain... Muhahah... no joke");
            sb.append(System.lineSeparator());
            sb.append("PRESS '6' for printing the whole minionBand... Banana...");
            sb.append(System.lineSeparator());
            sb.append("PRESS '7' for increasing age and capitalazing name both with usp... Boooow...");
            sb.append(System.lineSeparator());
            sb.append("PRESS '8' for increasing age of One minion and printing it... Boooow...");
            System.out.println(sb.toString());

            String command;

            while (!"Quit".equals(command = reader.readLine())) {

                switch (command) {
                    case "1":
                        GetNames.getNames(conn, 3);
                        break;

                    case "2":

                        System.out.print("Enter villian ID:");
                        int id = Integer.parseInt(reader.readLine());

                        GetMinions.getMinions(conn, id);
                        break;

                    case "3":
                        System.out.println("Enter Minion in format: 'Minion: name age town'");
                        System.out.println("Enter Villain in format: 'Villain: name' :");

                        String[] minionArguments = reader.readLine().split("\\s+");
                        System.out.println();
                        String[] villain = reader.readLine().split("\\s+");

                        AddMinions.getNames(conn, villain[1], minionArguments[3], minionArguments[1], minionArguments[2]);

                        break;

                    case "4":
                        System.out.println("Enter country for which you would like to capitalize the cities name");
                        String countryName = reader.readLine().trim();
                        if (countryName == null || countryName.isEmpty()) {
                            break;
                        }
                        ChangeTownNames.getNames(conn, countryName);
                        break;
                    case "5":
                        System.out.println("Enter the villain ID you would like to assasinate: ");
                        try {
                            int idVillain = Integer.parseInt(reader.readLine());
                            DeleteVillain.headShoot(conn, idVillain);
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong Input --- you need to enter a number you drunked s-n -f a B-t-h !");
                        }

                        break;

                    case "6":
                        PrintMinions.print(conn, "fuzzy", null);
                        break;

                    case "7":
                        System.out.println("Enter minion ID or minion IDs separated by space:");
                        int[] ids = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

                        for (int i : ids) {
                            IncreaseAge.getOlder(conn, i);
                            Capitalize.capitalizeName(conn, i);
                        }
                        PrintMinions.print(conn, "normal", null);
                        break;
                    case "8":
                        System.out.println("Enter minion ID in order to increase his age:");
                        try {
                            int idForAge = Integer.parseInt(reader.readLine());
                            IncreaseAge.getOlder(conn, idForAge);
                            PrintMinions.print(conn, "normal", idForAge);
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong Input you.... Banana");
                        }


                        break;

                    default:
                        System.out.println("Wrong Input ! Forgot the Menu ? Do you want a fresh look? y/n");
                        String inputs = reader.readLine();
                        if (inputs.equals("Y") || inputs.equals("y") || inputs.equals("Yes") ||inputs.equals("yes")){

                        System.out.println(sb.toString());
                    }
                    break;
                }

            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
        }

    }

}
