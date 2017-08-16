package animals;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 19:29.
 */
public class Kitten extends Animal{
    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public String makeSound() {
        return "Miau";
    }
}
