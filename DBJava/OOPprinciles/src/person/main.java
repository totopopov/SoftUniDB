package person;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 18:28.
 */
public class main {
    public static void main(String[] args) {

            Class[] citizenInterfaces = Citizen.class.getInterfaces();
            if(Arrays.asList(citizenInterfaces).contains(Person.class)){
                Method[] fields = Person.class.getDeclaredMethods();
                System.out.println(fields.length);
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                int age = Integer.parseInt(scanner.nextLine());
                Person person = new Citizen(name,age);
                System.out.println(person.getName());
                System.out.println(person.getAge());
            }
    }

}
