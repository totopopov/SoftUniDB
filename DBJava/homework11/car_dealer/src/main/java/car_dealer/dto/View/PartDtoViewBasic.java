package car_dealer.dto.View;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:10.
 */


public class PartDtoViewBasic {

    private Long id;

    public PartDtoViewBasic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
