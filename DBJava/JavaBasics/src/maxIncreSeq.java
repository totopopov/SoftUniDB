import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 15:27.
 */
public class maxIncreSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] alfa = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int lenght=1;
        int maxLenght=1;
        int max=alfa[0];

        for (int i = 1; i < alfa.length; i++) {
            if (alfa[i-1]<alfa[i]){
                lenght++;
            }else {
                lenght=1;
            }

            if (lenght>maxLenght){
                maxLenght=lenght;
                max=i;
            }

        }
        String out="";
        for (int i = max-maxLenght+1; i <= max; i++) {
           out+= (alfa[i]+" ");
        }
        System.out.println(out.trim());

    }
}
