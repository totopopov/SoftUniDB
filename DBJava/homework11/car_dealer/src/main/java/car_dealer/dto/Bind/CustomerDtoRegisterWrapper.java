package car_dealer.dto.Bind;



import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:21.
 */

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDtoRegisterWrapper {

    @XmlElement(name = "customer")
    List<CustomerDtoRegister> customers;

    public List<CustomerDtoRegister> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDtoRegister> customers) {
        this.customers = customers;
    }
}
