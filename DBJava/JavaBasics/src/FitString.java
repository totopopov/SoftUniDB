import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 16:58.
 */
public class FitString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input=scanner.nextLine();
        int diff=20-input.length();

        if (diff<=0){
            System.out.println(input.substring(0,20));
        }else {
            String addition=String.join("", Collections.nCopies(diff,"*"));
            System.out.println(input+addition);
        }



    }
}
