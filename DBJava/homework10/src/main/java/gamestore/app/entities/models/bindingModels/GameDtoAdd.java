package gamestore.app.entities.models.bindingModels;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 2.8.2017 г. at 20:18.
 */
public class GameDtoAdd {

    @Length(min = 3,max = 100,message = "Title must be between 3 and 100 symbols")
    @Pattern(regexp = "[A-Z].+",message = "Title must start with Capital letter")
    private String title;




    @DecimalMin(value = "0.00",message = "Price must be possitive")
    @Digits(integer = Integer.MAX_VALUE,fraction = 2,message = "Precision of price should be up to 2 digits after floating point")
    private BigDecimal price;

    @Digits(integer = Integer.MAX_VALUE,fraction = 1,message = "Precision of size should be up to 1 digits after floating point")
    private BigDecimal size;

    @Length(min = 11,max = 11)
    private String trailer;

    @Pattern(regexp = "((http:\\/\\/)|(https:\\/\\/)).*", message = "It should be a plain text starting with http://, https://.")
    private String thumbnailURL;


    @Length(min = 20)
    private String description;

    private Date releaseDate;

    public GameDtoAdd() {
    }

    public GameDtoAdd(String title, BigDecimal price, BigDecimal size, String trailer, String thumbnailURL, String description, Date releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailURL = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
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
