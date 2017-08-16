package car_dealer.dto.View;

import com.google.gson.annotations.Expose;

import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:21.
 */
public class CarDtoViewBasic {

    private Long id;

    public CarDtoViewBasic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
