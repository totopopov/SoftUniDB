package exam.hiber_spring.dto.bind;

import exam.hiber_spring.entitites.Branch;
import exam.hiber_spring.entitites.EmployeeCard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:15.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDtoRegister {


    @XmlAttribute(name = "first-name")
    private String firstName;


    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute(name = "position")
    private String position;

    @XmlElement(name = "card")
    private String cardString;

    @XmlElement(name = "branch")
    private String branchString;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCardString() {
        return cardString;
    }

    public void setCardString(String cardString) {
        this.cardString = cardString;
    }

    public String getBranchString() {
        return branchString;
    }

    public void setBranchString(String branchString) {
        this.branchString = branchString;
    }
}
