import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 14:50.
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner scannner = new Scanner(System.in);

        StringBuilder sb=new StringBuilder(scannner.nextLine());
        sb.append(scannner.nextLine());
        sb.append(scannner.nextLine());

        System.out.println(sb.reverse().toString());
    }
}
