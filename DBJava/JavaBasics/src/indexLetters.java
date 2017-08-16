import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 16:31.
 */
public class indexLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] data=scanner.nextLine().toCharArray();

        for (char datum : data) {
            System.out.println(String.format("%s -> %d",datum,(int)datum-97));
        }

    }
}
