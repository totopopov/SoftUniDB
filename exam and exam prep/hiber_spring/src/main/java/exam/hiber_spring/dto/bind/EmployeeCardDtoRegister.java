package exam.hiber_spring.dto.bind;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:17.
 */


public class EmployeeCardDtoRegister {

    @Expose
    private String number;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeCardDtoRegister that = (EmployeeCardDtoRegister) o;

        return number != null ? number.equals(that.number) : that.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
