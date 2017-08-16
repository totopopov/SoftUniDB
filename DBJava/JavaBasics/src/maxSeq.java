import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 15:27.
 */
public class maxSeq {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] alfa = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int lenght = 1;
        int maxLenght = 1;
        int max = alfa[0];

        for (int i = 1; i < alfa.length; i++) {
            if (alfa[i - 1] == alfa[i]) {
                lenght++;
            } else {
                lenght = 1;
            }

            if (lenght > maxLenght) {
                maxLenght = lenght;
                max = alfa[i];
            }

        }
        String out = "";
        for (int i = 0; i < maxLenght; i++) {
            out += (max + " ");
        }
        System.out.println(out.trim());

    }
}
