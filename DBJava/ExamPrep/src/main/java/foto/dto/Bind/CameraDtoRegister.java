package foto.dto.Bind;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import foto.entities.BasicCamer;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 21:39.
 */

public class CameraDtoRegister {


    @Expose
    private String type;

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    @SerializedName(value = "isFullFrame")
    private Boolean frame;
    @Expose
    @SerializedName(value = "minISO")
    private Integer minIso;
    @Expose
    @SerializedName(value = "maxISO")
    private Integer maxIso;


    @Expose
    @SerializedName(value = "MaxShutterSpeed")
    private Integer maxShutterSpeed;


    @Expose
    private String maxVideoResolution;
    @Expose
    @SerializedName(value = "maxFrameRate")
    private Integer frameRate;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getFrame() {
        return frame;
    }

    public void setFrame(Boolean frame) {
        this.frame = frame;
    }

    public Integer getMinIso() {
        return minIso;
    }

    public void setMinIso(Integer minIso) {
        this.minIso = minIso;
    }

    public Integer getMaxIso() {
        return maxIso;
    }

    public void setMaxIso(Integer maxIso) {
        this.maxIso = maxIso;
    }

    public Integer getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    public String getMaxVideoResolution() {
        return maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public Integer getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(Integer frameRate) {
        this.frameRate = frameRate;
    }


}
