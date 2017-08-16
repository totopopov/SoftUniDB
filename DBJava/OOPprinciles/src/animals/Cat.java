package animals;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 19:28.
 */
public class Cat extends Animal {
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String makeSound() {
        return "MiauMiau";
    }
}
