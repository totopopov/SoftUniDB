package gamestore.app.entities.models.viewModels;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 22:04.
 */
public class GameDtoDetailedInfo {

    private String title;
    private String trailer;
    private String thumbnailURL;
    private BigDecimal size;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    public GameDtoDetailedInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
