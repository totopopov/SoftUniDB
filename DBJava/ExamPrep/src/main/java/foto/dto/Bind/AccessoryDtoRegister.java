package foto.dto.Bind;

import foto.dto.View.PhotographerDtoViewBasic;
import foto.entities.Photographer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;


/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:09.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryDtoRegister {

    @XmlAttribute(name = "name")
    private String name;

    @XmlTransient
    private PhotographerDtoViewBasic owner;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhotographerDtoViewBasic getOwner() {
        return owner;
    }

    public void setOwner(PhotographerDtoViewBasic owner) {
        this.owner = owner;
    }
}
