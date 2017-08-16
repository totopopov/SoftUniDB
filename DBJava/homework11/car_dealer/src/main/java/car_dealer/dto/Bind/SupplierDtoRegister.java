package car_dealer.dto.Bind;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 21:44.
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class SupplierDtoRegister {

    @Expose
    @XmlAttribute(name = "name")
    private String name;
    @Expose
    @SerializedName("isImporter")
    @XmlAttribute(name = "is-importer")
    private Boolean Imported;

    public SupplierDtoRegister() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImported() {
        return Imported;
    }

    public void setImported(Boolean imported) {
        Imported = imported;
    }
}
