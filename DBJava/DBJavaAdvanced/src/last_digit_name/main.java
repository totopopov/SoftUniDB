package last_digit_name;

import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 20:28.
 */
public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Number number=new Number(Integer.parseInt(scanner.nextLine()));

        System.out.println(number.getLastDigit());

    }
}
