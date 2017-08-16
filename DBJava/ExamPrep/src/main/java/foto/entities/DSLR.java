package foto.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:04.
 */

@Entity
@DiscriminatorColumn(name = "DSLR")
public class DSLR extends BasicCamer {

    private Integer maxShutterSpeed;

    public DSLR() {
    }

    public Integer getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }
}
