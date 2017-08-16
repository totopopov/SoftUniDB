import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 20:18.
 */
public class StudentExtEvenMore {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String[]> data = new LinkedList<>();


        String input = "";

        while (!"END".equals(input=reader.readLine())){
            String[] tokens=input.split("\\s+");
            data.add(tokens);
        }

        data.stream()
                .filter(c->Integer.parseInt(c[2])<=24 &&Integer.parseInt(c[2])>=18)
                .forEach(c-> System.out.println(String.format("%s %s %s",c[0],c[1],c[2])));

    }
}
