package beerCounter;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 8.7.2017 г. at 15:49.
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input=scanner.nextLine();

        while (!"End".equals(input) || input.equals(null) || input.trim().isEmpty()){

            Beer.buyBeer(Integer.parseInt(input.split("\\s+")[0]));
            Beer.drinkBeer(Integer.parseInt(input.split("\\s+")[1]));

            try {
                input=scanner.nextLine();
            }catch (NoSuchElementException npe){
                break;
            }
        }

        System.out.println(String.format("%d %d",Beer.beerStock,Beer.beerDrank));

    }
}
