import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 17:18.
 */
public class censorEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String email=scanner.nextLine();
        String replaced=email.substring(0,email.lastIndexOf("@")).replaceAll(".","*");
        replaced=replaced+email.substring(email.lastIndexOf("@"));

        String text=scanner.nextLine();
        System.out.println(text.replace(email,replaced));





    }
}
