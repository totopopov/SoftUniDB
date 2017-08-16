package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 11:52.
 */

public class CategoryDto {

    private Long id;

    public CategoryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
