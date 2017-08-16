package border;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 20:48.
 */
public class Robot implements Robotable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
