package car_dealer.dto.View;

import car_dealer.app.entities.Part;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:03.
 */

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierViewInfoWrapper {

    @XmlElement(name = "suplier")
    private List<SupplierViewInfo> suppliers;

    public List<SupplierViewInfo> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierViewInfo> suppliers) {
        this.suppliers = suppliers;
    }
}
