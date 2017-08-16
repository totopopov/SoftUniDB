package draw;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 15:47.
 */
public class Rectangle implements Drawable {
    private int width;
    private int height;

    public Rectangle(int sizeA, int sizeB) {
        this.width = sizeA;
        this.height = sizeB;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            System.out.print("*");
            for (int k = 1; k < width - 1; k++) {
                System.out.print(" ");
                if (i == 0 || i == (height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print(" ");
            System.out.print("*");
            System.out.print("\n");


        }
    }
}
