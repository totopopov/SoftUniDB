package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 3:04.
 */
public class UserDto {

    private Long id;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
