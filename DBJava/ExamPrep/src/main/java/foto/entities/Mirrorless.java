package foto.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:05.
 */

@Entity
@DiscriminatorColumn(name = "Mirrorless")
public class Mirrorless extends BasicCamer {
    private String maxVideoResolution;
    private Integer frameRate;

    public Mirrorless() {
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
