package shopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        try {
            String[] input = Arrays.stream(reader.readLine().split(";")).toArray(String[]::new);
            for (String s : input) {
                String[] arguents = Arrays.stream(s.split("=")).toArray(String[]::new);
                Person person = new Person(arguents[0], Double.parseDouble(arguents[1]));
                people.putIfAbsent(person.getName(), person);
            }
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String[] productsArg = Arrays.stream(reader.readLine().split(";")).toArray(String[]::new);

            for (String s : productsArg) {
                String[] arguents = Arrays.stream(s.split("=")).toArray(String[]::new);
                Product product = new Product(arguents[0], Double.parseDouble(arguents[1]));
                products.putIfAbsent(product.getName(), product);
            }
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
            return;
        }

        String command = "";
        command = reader.readLine();
        while (!"END".equals(command)) {

            String[] arguments = Arrays.stream(command.split("\\s+")).toArray(String[]::new);

            try {

                System.out.println(people.get(arguments[0]).buyProduct(products.get(arguments[1])));

            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            command = reader.readLine();
        }

        for (Person person : people.values()) {
            System.out.println(person);
        }
    }
}
