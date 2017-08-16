package border;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 20:45.
 */
public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthdatable> data = new LinkedList<>();

        String command="";

        while (!"End".equals(command=reader.readLine())){

            String[] arguments=command.split("\\s+");

            switch (arguments[0]){
                case "Citizen":
                    Citizen citizen= new Person(arguments[1],arguments[2],arguments[3],arguments[4]);
                    data.add(citizen);
                    break;
                case "Pet":
                    Petable pet = new Pet(arguments[1],arguments[2]);
                    data.add(pet);
                    break;
                    default:
                        break;
            }

        }

        String date=reader.readLine();

        for (Birthdatable datum : data) {
            if (datum.getDate().endsWith(date)){
                System.out.println(datum.getDate());
            }
        }

    }
}
