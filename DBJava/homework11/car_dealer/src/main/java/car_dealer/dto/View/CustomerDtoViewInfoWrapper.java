package car_dealer.dto.View;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 18:50.
 */

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDtoViewInfoWrapper {

    @XmlElement(name = "customer")
    private List<CustomerDtoViewInfo> customers;

    public List<CustomerDtoViewInfo> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDtoViewInfo> customers) {
        this.customers = customers;
    }
}
