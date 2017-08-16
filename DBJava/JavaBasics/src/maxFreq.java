import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 15:27.
 */
public class maxFreq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] alfa = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> data=new LinkedHashMap<>();

        for (int i = 0; i < alfa.length; i++) {

            if (data.containsKey(alfa[i])){
                data.put(alfa[i],data.get(alfa[i])+1);
            }else {
                data.put(alfa[i],1);
            }

        }


        int max=0;
        int maxElement=alfa[0];


        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {

            if (entry.getValue()>max){
                max=entry.getValue();
                maxElement=entry.getKey();
            }
        }

        System.out.println(maxElement);

    }
}
