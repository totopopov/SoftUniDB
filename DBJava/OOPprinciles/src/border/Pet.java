package border;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 21:06.
 */
public class Pet implements Petable {
    private String name;
    private String date;

    public Pet(String name, String date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
