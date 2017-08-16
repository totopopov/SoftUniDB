package students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name;

        while (!"End".equals(name=reader.readLine())){
            Student student=new Student(name);
        }

        System.out.println(Student.counter);
    }
}
