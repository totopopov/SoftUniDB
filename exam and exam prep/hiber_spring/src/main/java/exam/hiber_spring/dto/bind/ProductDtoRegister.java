package exam.hiber_spring.dto.bind;

import exam.hiber_spring.entitites.Branch;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:27.
 */


@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDtoRegister {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "clients")
    private Integer clients;

    @XmlElement(name = "branch")
    private String  branchString;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    public String getBranchString() {
        return branchString;
    }

    public void setBranchString(String branchString) {
        this.branchString = branchString;
    }
}
