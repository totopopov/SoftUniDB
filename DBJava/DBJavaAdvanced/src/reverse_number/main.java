package reverse_number;

import java.lang.*;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Number number= new Number(scanner.nextLine());

        System.out.println(number.ReverseNumber());

        System.out.println();

    }
}
