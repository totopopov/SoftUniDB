package foto.dto.Bind;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:59.
 */

public class LensDtoRegister {

    @Expose

    private String make;

    @Expose
    @SerializedName(value = "focalLength")
    private Integer focalLenght;

    @Expose
    @SerializedName(value = "maxAperture")
    private BigDecimal maxApreture;

    @Expose
    private String compatibleWith;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getFocalLenght() {
        return focalLenght;
    }

    public void setFocalLenght(Integer focalLenght) {
        this.focalLenght = focalLenght;
    }

    public BigDecimal getMaxApreture() {
        return maxApreture;
    }

    public void setMaxApreture(BigDecimal maxApreture) {
        this.maxApreture = maxApreture;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }
}
