package gamestore.app.entities.models.viewModels;

import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 22:04.
 */
public class GameDtoInfo {
    private String title;
    private BigDecimal price;

    public GameDtoInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
