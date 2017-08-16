package exam.hiber_spring.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import exam.hiber_spring.entitites.Branch;
import exam.hiber_spring.entitites.EmployeeCard;



/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:15.
 */



public class EmployeeDtoViewProjected {

    @Expose
    @SerializedName(value = "full_name")
    private String fullName;

    @Expose
    private String position;

    @Expose
    private String number;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
