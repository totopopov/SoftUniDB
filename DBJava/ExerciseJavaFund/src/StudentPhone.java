import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 20:18.
 */
public class StudentPhone {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String[]> data = new LinkedList<>();


        String input = "";

        while (!"END".equals(input=reader.readLine())){
            String[] tokens=input.split("\\s+");
            data.add(tokens);
        }

        data.stream()
                .filter(c->c[2].startsWith("02") || c[2].startsWith("+3592"))
                .forEach(c-> System.out.println(String.format("%s %s",c[0],c[1])));

    }
}
