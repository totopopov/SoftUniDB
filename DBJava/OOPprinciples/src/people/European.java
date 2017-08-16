package people;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 16:50.
 */
public class European implements Person {

    private String name;


    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
