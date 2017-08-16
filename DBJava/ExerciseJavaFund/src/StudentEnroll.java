import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 20:18.
 */
public class StudentEnroll {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String[]> data = new LinkedList<>();


        String input = "";

        while (!"END".equals(input=reader.readLine())){
            String[] tokens=input.split("\\s+");
            data.add(tokens);
        }

        data.stream()
                .filter(c->c[0].endsWith("15") || c[0].endsWith("14"))
                .forEach(c-> System.out.println(Arrays.stream(c).skip(1).collect(Collectors.joining(" "))));

    }
}
