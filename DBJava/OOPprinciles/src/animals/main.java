package animals;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 19:34.
 */
public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        List<Beast> beast = new LinkedList<>();
        while (!"Beast!".equals(input = reader.readLine())) {

            try {

                if (input == null || input.isEmpty()) {
                    throw new IllegalArgumentException("Invalid input!");
                }

                String[] arguments = reader.readLine().split("\\s+");

                if (arguments.length != 3) {
                    throw new IllegalArgumentException("Invalid input!");
                }


                switch (input) {
                    case "Cat":
                        try {
                            Beast cat = new Cat(arguments[0], Integer.parseInt(arguments[1]), arguments[2]);
                            beast.add(cat);

                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    case "Dog":
                        try {
                            Beast dog = new Dog(arguments[0], Integer.parseInt(arguments[1]), arguments[2]);
                            beast.add(dog);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }

                        break;
                    case "Frog":
                        try {

                            Beast frog = new Frog(arguments[0], Integer.parseInt(arguments[1]), arguments[2]);
                            beast.add(frog);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    case "Tomcat":
                        try {
                            Beast tomcat = new Tomcat(arguments[0], Integer.parseInt(arguments[1]));
                            beast.add(tomcat);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    case "Kitten":
                        try {

                            Beast kittens = new Kitten(arguments[0], Integer.parseInt(arguments[1]));
                            beast.add(kittens);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }

            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }


        }

        for (Beast beast1 : beast) {
            System.out.println(beast1);
            System.out.println(beast1.makeSound());
        }

    }
}
