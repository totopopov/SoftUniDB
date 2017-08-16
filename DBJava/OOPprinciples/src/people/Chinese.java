package people;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 16:51.
 */
public class Chinese implements Person {

    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
