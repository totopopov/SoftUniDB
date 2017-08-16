import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 16:42.
 */
public class equalSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] alfa = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum= Arrays.stream(alfa).sum();
        boolean shot=true;
        int currentSum=0;
        for (int i = 0; i < alfa.length; i++) {

            if (currentSum==sum-alfa[i]-currentSum){
                System.out.println(i);
                shot=false;
                return;
            }

            currentSum+=alfa[i];

        }

        if (shot){
            System.out.println("no");
        }



    }
}
