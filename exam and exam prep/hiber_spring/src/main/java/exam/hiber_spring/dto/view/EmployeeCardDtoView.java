package exam.hiber_spring.dto.view;

import com.google.gson.annotations.Expose;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:17.
 */


public class EmployeeCardDtoView {

    @Expose
    private String number;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
