package students;

public class Student {
    public static int counter;

    private String name;

    public Student(String name) {
        this.name = name;
        Student.counter++;
    }
}
