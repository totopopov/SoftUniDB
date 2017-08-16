package car_dealer.dto.View;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 9.8.2017 г. at 23:22.
 */

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDtoViewDetailedWrapper {

    @XmlElement(name = "sale")
    private List<SaleDtoViewDetailed> sales;

    public List<SaleDtoViewDetailed> getSales() {
        return sales;
    }

    public void setSales(List<SaleDtoViewDetailed> sales) {
        this.sales = sales;
    }
}
