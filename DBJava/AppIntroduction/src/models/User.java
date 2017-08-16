package models;
import java.time.LocalDate;


public class User {
    private long id=0x0000;
    private String name;
    private int age;
    private LocalDate registrationDate;


    public User(String name, int age, LocalDate registrationDate) {
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
