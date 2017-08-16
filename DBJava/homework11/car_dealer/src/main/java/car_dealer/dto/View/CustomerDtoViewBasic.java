package car_dealer.dto.View;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 22:21.
 */
public class CustomerDtoViewBasic {

    private Long id;

    public CustomerDtoViewBasic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
