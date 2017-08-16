import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 10.8.2017 г. at 12:22.
 */
public class Hello {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input=scanner.nextLine();

        int number= Integer.parseInt(input);

        System.out.println(input);

    }
}
