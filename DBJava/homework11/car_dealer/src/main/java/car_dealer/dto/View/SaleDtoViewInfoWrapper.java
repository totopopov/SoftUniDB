package car_dealer.dto.View;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 23:22.
 */

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDtoViewInfoWrapper {

    @XmlElement(name = "customer")
    private List<SaleDtoViewInfo> customers;

    public List<SaleDtoViewInfo> getCustomers() {
        return customers;
    }

    public void setCustomers(List<SaleDtoViewInfo> customers) {
        this.customers = customers;
    }
}
