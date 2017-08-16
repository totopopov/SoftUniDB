package groupBy;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 20:55.
 */
public class Person {
    private String name;
    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return this.name;
    }

    public int getGroup() {
        return this.group;
    }
}
