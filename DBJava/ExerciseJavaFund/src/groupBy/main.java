package groupBy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 20:56.
 */
public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> data=new LinkedList<>();

        String input = "";

        while (!"END".equals(input=reader.readLine())){
            String[] tokens=input.split("\\s+");
            Person person=new Person(String.format("%s %s",tokens[0],tokens[1]),Integer.parseInt(tokens[2]));
            data.add(person);
        }

        data.stream().collect(Collectors.groupingBy(Person::getGroup))
                .entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach(p-> System.out.println(String.format("%s - %s",p.getKey(), p.getValue().stream()
                        .map(Person::getName).collect(Collectors.joining(", "))  )));
    }
}
