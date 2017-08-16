package averageGrades;

import java.util.Arrays;

/**
 * Created by Todor Popov using Lenovo on 8.7.2017 г. at 14:40.
 */
public class Student {
    private String name;
    private double[] grades;

    public Student(String name, double... grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return this.name;
    }

    public double getAverageGrade(){
        return Arrays.stream(this.grades).average().orElse(0);
    }

    @Override
    public String toString() {
        return String.format("%s -> %.2f",this.getName(),this.getAverageGrade());
    }
}
