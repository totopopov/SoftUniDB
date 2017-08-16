package draw;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 15:48.
 */
public class main {

    public static void main(String[] args) {


        Drawable circle = new Circle(8);

        Drawable rect = new Rectangle(7, 5);

        circle.draw();

        rect.draw();


    }
}
