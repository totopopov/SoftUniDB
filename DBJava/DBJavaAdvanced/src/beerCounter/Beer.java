package beerCounter;

/**
 * Created by Todor Popov using Lenovo on 8.7.2017 г. at 15:46.
 */
public class Beer {

    public static int beerStock;
    public static int beerDrank;

    public static void buyBeer(int beer){
        Beer.beerStock+=beer;
    }

    public static void drinkBeer(int beer){
        Beer.beerStock-=beer;
        Beer.beerDrank+=beer;
    }

}
