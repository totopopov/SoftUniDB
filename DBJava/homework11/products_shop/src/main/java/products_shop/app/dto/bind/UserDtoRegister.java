package products_shop.app.dto.bind;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 3:04.
 */

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDtoRegister {

    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;

    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;

    @Expose
    @XmlAttribute(name = "age")
    private Integer age;

    public UserDtoRegister() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
