package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:25.
 */

@Entity
@Table(name = "ship")
public class Ship extends MotorVehicle {
    private String nationality;
    private String captainsName;
    private Integer sizeOfCrew;


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "captains_name")
    public String getCaptainsName() {
        return captainsName;
    }

    public void setCaptainsName(String captainsName) {
        this.captainsName = captainsName;
    }

    @Column(name = "size_of_crew")
    public Integer getSizeOfCrew() {
        return sizeOfCrew;
    }

    public void setSizeOfCrew(Integer sizeOfCrew) {
        this.sizeOfCrew = sizeOfCrew;
    }
}
