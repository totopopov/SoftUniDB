package exam.hiber_spring.dto.view;

import exam.hiber_spring.entitites.Town;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:20.
 */



@XmlAccessorType(XmlAccessType.FIELD)
public class BranchDtoViewInfo {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "town")
    private String townStirng;

    @XmlAttribute(name = "total_clients")
    private Long clinets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownStirng() {
        return townStirng;
    }

    public void setTownStirng(String townStirng) {
        this.townStirng = townStirng;
    }

    public Long getClinets() {
        return clinets;
    }

    public void setClinets(Long clinets) {
        this.clinets = clinets;
    }
}
