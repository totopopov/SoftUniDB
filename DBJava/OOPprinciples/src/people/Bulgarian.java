package people;

/**
 * Created by Todor Popov using Lenovo on 3.7.2017 г. at 16:49.
 */
public class Bulgarian implements Person {
    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
