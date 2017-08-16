package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 21:40.
 */
public class main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentArg=reader.readLine().split("\\s+");
        String[] workerArg=reader.readLine().split("\\s+");

        String debug="";

        try {
            Student student=new Student(studentArg[0],studentArg[1],studentArg[2]);
            System.out.println(student);

            Worker worker=new Worker(workerArg[0],workerArg[1],Double.parseDouble(workerArg[2]),Double.parseDouble(workerArg[3]));
            System.out.println(worker);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }


    }
}
