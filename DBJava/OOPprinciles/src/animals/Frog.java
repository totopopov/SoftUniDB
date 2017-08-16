package animals;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 19:28.
 */
public class Frog extends Animal {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String makeSound() {
        return "Frogggg";
    }
}
