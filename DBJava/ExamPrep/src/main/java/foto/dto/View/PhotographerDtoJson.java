package foto.dto.View;

import com.google.gson.annotations.Expose;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 1:10.
 */
public class PhotographerDtoJson {


    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
