package insertion_of_circles;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 21:10.
 */
public class Circle {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getRadius() {
        return this.radius;
    }

    public boolean intersect(Circle circle) {

        int x = this.x-circle.getX();
        int y = this.y-circle.getY();

        return !(Math.sqrt(x * x + y * y) > this.radius + circle.getRadius());
    }


}
