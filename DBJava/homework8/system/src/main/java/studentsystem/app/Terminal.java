package studentsystem.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import studentsystem.app.models.Course;
import studentsystem.app.models.Homework;
import studentsystem.app.models.Resource;
import studentsystem.app.models.Student;
import studentsystem.app.services.interfaces.CourseService;
import studentsystem.app.services.interfaces.HomeworkService;
import studentsystem.app.services.interfaces.ResourceService;
import studentsystem.app.services.interfaces.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Todor Popov using Lenovo on 26.7.2017 г. at 19:49.
 */


@Controller
public class Terminal implements CommandLineRunner {
    private final ResourceService resourceService;
    private final StudentService studentService;
    private final CourseService courseService;
    private final HomeworkService homeworkService;

    @Autowired
    public Terminal(ResourceService resourceService, StudentService studentService, CourseService courseService, HomeworkService homeworkService) {
        this.resourceService = resourceService;
        this.studentService = studentService;
        this.courseService = courseService;
        this.homeworkService = homeworkService;
    }

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("sucess");
        //seedDatabase();

        // task 1
//        List<Object[]> stundentNameAndHomeworkInfo = this.studentService.findStundentNameAndHomeworkInfo();
//
//        for (Object[] objects : stundentNameAndHomeworkInfo) {
//            System.out.println(String.format("%s %s %s",objects[0],objects[1],objects[2]));
//        }

//        task 2
//        List<Object[]> allWithInformationForResources = this.courseService.findWithInformationForResources();
//        for (Object[] allWithInformationForResource : allWithInformationForResources) {
//            System.out.println(Arrays.stream(allWithInformationForResource).
//                    filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(" ")));
//        }


        // just 1 for task 3
//                List<Object[]> allWithInformationForResources = this.courseService.fetchCoursesWIthMoreThan5Resourse(2);
//        for (Object[] allWithInformationForResource : allWithInformationForResources) {
//            System.out.println(Arrays.stream(allWithInformationForResource).
//                    filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(" ")));
//        }

        DateFormat df =new SimpleDateFormat("mmddyyyy");
        Date date=df.parse("01011800");
        List<Object[]> withingGivenDate = this.courseService.takeCoursesActiveOnGivenDate(date);
        for (Object[] allWithInformationForResource : withingGivenDate) {
            System.out.println(Arrays.stream(allWithInformationForResource).
                    filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(" ")));
        }

    }

    private void seedDatabase() throws IOException, ParseException {

        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("mm.dd.yy");
        Random random = new Random();


        seedStudents(random, df, students);
        getCourse(courses,students, df, random);
        getResources(courses, random);
        getHomework(students, courses, df, random);

    }

    private void getHomework(List<Student> students, List<Course> courses, DateFormat df, Random random) throws IOException, ParseException {
        InputStream source = getClass().getResourceAsStream("/homeworks.txt");
//        BufferedReader authorsReader = new BufferedReader(new FileReader("/authors.txt"));
        BufferedReader authorsReader = new BufferedReader(new InputStreamReader(source));
        String authorLine = authorsReader.readLine();
        while ((authorLine = authorsReader.readLine()) != null) {
            String[] data = authorLine.split("\\s+");

            String content = null;
            String contentType = null;
            Date submissionDate = null;


            content = data[0];
            contentType = data[1];
            submissionDate = df.parse(data[2]);

            Homework homework = new Homework(content, contentType, submissionDate);
            int course = random.nextInt(courses.size());

            int categoryCount = 0;


            Course currentCourse = courses.get(course);

            homework.setCourse(currentCourse);


            int homeNumber = random.nextInt(students.size());

            Student student = students.get(homeNumber);

            homework.setStudent(student);

            homeworkService.register(homework);
        }
    }

    private void seedStudents(Random random, DateFormat df, List<Student> students) throws IOException, ParseException {

        StringBuilder sb = new StringBuilder();
        InputStream source = getClass().getResourceAsStream("/students.txt");
        BufferedReader booksReader = new BufferedReader(new InputStreamReader(source));
        String line = booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String name = data[0];
            String phone = data[1];
            Date date = df.parse(data[2]);
            Date date1 = df.parse(data[3]);

            Student student = new Student(name, phone, date, date1);
            students.add(student);
            studentService.register(student);
        }
    }

    private void getCourse(List<Course> courses, List<Student> students, DateFormat df, Random random) throws IOException, ParseException {
        InputStream source = getClass().getResourceAsStream("/courses.txt");
        BufferedReader categoryReader = new BufferedReader(new InputStreamReader(source));
        String categoryLIne = categoryReader.readLine();
        while ((categoryLIne = categoryReader.readLine()) != null) {
            String[] data = categoryLIne.split("\\s+");

            String categoryName = data[0];
            String categoryType = data[1];
            Date date = df.parse(data[2]);
            Date date1 = df.parse(data[3]);
            BigDecimal price = new BigDecimal(data[4]);

            Course course = new Course(categoryName, categoryType, date, date1, price);

            int studentNumber=random.nextInt(50);

            int studentCount=0;

            Set<Student> studentSet = new HashSet<>();
            while (studentCount<studentNumber){
                Student category=students.get(random.nextInt(students.size()));
                if (!studentSet.contains(category)){
                    studentSet.add(category);
                    studentCount++;
                }
            }

            course.setStudents(studentSet);
            courses.add(course);
            this.courseService.register(course);
        }
    }

    private void getResources(List<Course> courses, Random random) throws IOException {
        InputStream source = getClass().getResourceAsStream("/resources.txt");
//        BufferedReader authorsReader = new BufferedReader(new FileReader("/authors.txt"));
        BufferedReader authorsReader = new BufferedReader(new InputStreamReader(source));
        String authorLine = authorsReader.readLine();
        while ((authorLine = authorsReader.readLine()) != null) {
            String[] data = authorLine.split("\\s+");


            String firstName = data[0];
            String type = data[1];
            String URL = data[2];

            Resource resource = new Resource(firstName, type, URL);

            int categoryNumber = random.nextInt(courses.size());

            int categoryCount = 0;

            Course course = courses.get(categoryNumber);
            resource.setCourse(course);
            this.resourceService.register(resource);
        }
    }
}
