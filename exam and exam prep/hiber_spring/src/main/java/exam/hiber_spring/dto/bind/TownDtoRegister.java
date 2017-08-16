package exam.hiber_spring.dto.bind;


import com.google.gson.annotations.Expose;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:18.
 */

public class TownDtoRegister {


    @Expose
    private String name;

    @Expose
    private Integer population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
