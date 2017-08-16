package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 15:06.
 */


public class UserDtoViewFullName {

    private String firstName;

    private String lastName;

    public UserDtoViewFullName() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName==null?this.lastName:String.format("%s %s",this.firstName,this.lastName);
    }

}
