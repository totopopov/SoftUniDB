package ferrari;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 18:57.
 */
public class Ferrari implements Car {
    private String name;

    public Ferrari(String name) {
        this.name = name;
    }

    @Override
    public String getDriversName() {
        return this.name;
    }

    @Override
    public String getModel() {
        return "488-Spider";
    }

    @Override
    public String useBreaks() {
        return "Brakes!";
    }

    @Override
    public String useGas() {
        return "Zadu6avam sA!";
    }
}
