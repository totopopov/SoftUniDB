package exam.hiber_spring.dto.bind;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:20.
 */


public class BranchDtoRegister {


    @Expose
    private String name;

    @Expose
    @SerializedName(value = "town")
    private String townString;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownString() {
        return townString;
    }

    public void setTownString(String townString) {
        this.townString = townString;
    }
}
