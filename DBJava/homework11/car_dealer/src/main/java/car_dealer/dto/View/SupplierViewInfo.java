package car_dealer.dto.View;

import car_dealer.app.entities.Part;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:03.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierViewInfo {

    @XmlAttribute(name = "id")
    private Long id;

    @XmlAttribute(name = "name")
    private String name;

    @XmlTransient
    private Set<Part> parts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    @XmlAttribute(name = "parts-count")
    public Integer getSize(){
       return this.parts.size();
    }

}
