import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 15:17.
 */
public class comp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[] alfa =String.join("",(scanner.nextLine().split("\\s+"))).toCharArray();
        char[] omega=String.join("",(scanner.nextLine().split("\\s+"))).toCharArray();

        for (int i = 0; i < Math.min(alfa.length,omega.length); i++) {
            if (alfa[i]>omega[i]){
                System.out.println(omega);
                System.out.println(alfa);
                return;
            }

            if (alfa[i]<omega[i]){
                System.out.println(alfa);
                System.out.println(omega);
                return;
            }

        }

        if (alfa.length>=omega.length){
            System.out.println(omega);
            System.out.println(alfa);
        } else {
            System.out.println(alfa);
            System.out.println(omega);
        }

    }
}
