import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 20:18.
 */
public class StudentExcell {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String[]> data = new LinkedList<>();


        String input = "";

        while (!"END".equals(input=reader.readLine())){
            String[] tokens=input.split("\\s+");
            data.add(tokens);
        }

        data.stream()
                .filter(c-> Arrays.stream(c).skip(2).filter(e->e.equals("6")).count()>0)
                .forEach(c-> System.out.println(String.format("%s %s",c[0],c[1])));

    }
}
