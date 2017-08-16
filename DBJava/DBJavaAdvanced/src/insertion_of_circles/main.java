package insertion_of_circles;

import java.util.Arrays;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Circle circleOne=new Circle(input[0],input[1],input[2]);

        input= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(c->Integer.parseInt(c)).toArray();
        Circle circletwo=new Circle(input[0],input[1],input[2]);


        System.out.println(circleOne.intersect(circletwo)?"Yes":"No");


    }
}
