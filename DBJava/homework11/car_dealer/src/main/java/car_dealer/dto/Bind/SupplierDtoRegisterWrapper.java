package car_dealer.dto.Bind;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 21:44.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "suppliers")
public class SupplierDtoRegisterWrapper {

    @XmlElement(name = "supplier")
    List<SupplierDtoRegister> suppliers;

    public List<SupplierDtoRegister> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierDtoRegister> suppliers) {
        this.suppliers = suppliers;
    }
}
