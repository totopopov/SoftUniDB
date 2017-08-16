package animals;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 19:30.
 */
public class Tomcat extends Cat {
    public Tomcat(String name, int age) {
        super(name, age, "Male");
    }

    @Override
    public String makeSound() {
        return "Give me one million b***h";
    }
}
