package averageGrades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Todor Popov using Lenovo on 8.7.2017 г. at 14:42.
 */
public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberStudent=Integer.parseInt(reader.readLine());

        List<Student>data=new LinkedList<>();

        for (int i = 0; i < numberStudent; i++) {

            String[] input=reader.readLine().split("\\s+");


            Student student=new Student(input[0],
                    Arrays.stream(input).skip(1).mapToDouble(Double::parseDouble).toArray());

            data.add(student);



        }


        data.stream().filter(s->s.getAverageGrade()>=5)
                .sorted((s1,s2)->{
            if (s1.getName().compareTo(s2.getName())==0){
                return Double.compare(s2.getAverageGrade(),s1.getAverageGrade());
            }else {
                return s1.getName().compareTo(s2.getName());
            }
                })
                .forEach(System.out::println);
    }
}
