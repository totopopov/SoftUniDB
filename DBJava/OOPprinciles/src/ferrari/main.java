package ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 18:54.
 */
public class main {
    public static void main(String[] args) throws IllegalClassFormatException {


        Scanner scanner = new Scanner(System.in);

        Car car=new Ferrari(scanner.nextLine());

        System.out.println(car.getModel()+"/"+car.useBreaks()+"/"+car.useGas()+"/"+car.getDriversName());


        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }

    }
}
