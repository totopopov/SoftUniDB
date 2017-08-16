package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Todor Popov using Lenovo on 5.7.2017 г. at 17:05.
 */
public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carArguments = reader.readLine().split("\\s+");

        Drivable car = new Car(Double.parseDouble(carArguments[1]), Double.parseDouble(carArguments[2]));

        String[] truckArguments = reader.readLine().split("\\s+");
        Drivable truck = new Truck(Double.parseDouble(truckArguments[1]), Double.parseDouble(truckArguments[2]));

        int commands=Integer.parseInt(reader.readLine());

        for (int i = 0; i < commands; i++) {

            String[] arguments=reader.readLine().split("\\s+");

            switch (arguments[0]){
                case "Drive":
                    if (arguments[1].equals("Car")){
                        System.out.println(car.drive(Double.parseDouble(arguments[2])));
                    }
                    if (arguments[1].equals("Truck")){
                        System.out.println(truck.drive(Double.parseDouble(arguments[2])));
                    }
                    break;
                case "Refuel":
                    if (arguments[1].equals("Car")){
                        car.refuel(Double.parseDouble(arguments[2]));
                    }

                    if (arguments[1].equals("Truck")){
                        truck.refuel(Double.parseDouble(arguments[2]));
                    }
                    break;
            }
        }

        System.out.println(String.format("Car: %.2f",car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f",truck.getFuelQuantity()));


    }
}
