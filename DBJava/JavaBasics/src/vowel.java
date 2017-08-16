import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 14:58.
 */
public class vowel {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char ch=scanner.nextLine().charAt(0);


        if (Character.isDigit(ch)){
            System.out.println("digit");
        } else {
            ch=Character.toLowerCase(ch);

            if (ch=='a' || ch=='o'|| ch=='u' || ch=='e' || ch=='i' ){
                System.out.println("vowel");
            }else {
                System.out.println("other");
            }

        }



    }
}
