package foto.dto.View;

import foto.entities.Accessory;
import foto.entities.BasicCamer;
import foto.entities.Lens;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:07.
 */

public class PhotographerDtoViewBasic {


    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
