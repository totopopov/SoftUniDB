import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 20:18.
 */
public class Student {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String[]> data = new LinkedList<>();


        String input = "";

        while (!"END".equals(input=reader.readLine())){
            String[] tokens=input.split("\\s+");
            data.add(tokens);
        }

        data.stream()
                .filter(c->c[2].equals("2"))
                .sorted(Comparator.comparing(c2 -> c2[0]))
                .forEach(c-> System.out.println(String.format("%s %s",c[0],c[1])));




    }
}
