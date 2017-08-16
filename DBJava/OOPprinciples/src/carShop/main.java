package carShop;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 16:26.
 */
public class main {
    public static void main(String[] args) {

        Car seat = new Seat("Leon", "gra", 110, "Spain");

        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                seat.getModel(),
                seat.getColor(),
                seat.getHorsePower()));
        System.out.println(seat.toString());

    }
}
