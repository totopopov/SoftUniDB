package border;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 20:46.
 */
public class Person implements Citizen {
    private String name;
    private String id;
    private String age;
    private String date;

    public Person(String name,String age, String id, String date) {
        this.name = name;
        this.age=age;
        this.id = id;
        this.date=date;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDate() {
        return this.date;
    }
}
