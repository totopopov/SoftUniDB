import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 15:05.
 */
public class intToHex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data = Integer.parseInt(scanner.nextLine());
        System.out.println(Integer.toHexString(data).toUpperCase());
        System.out.println(Integer.toBinaryString(data));


    }
}
