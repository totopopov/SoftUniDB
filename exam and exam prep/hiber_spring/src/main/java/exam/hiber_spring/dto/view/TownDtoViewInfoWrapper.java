package exam.hiber_spring.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 11:47.
 */

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownDtoViewInfoWrapper {

    @XmlElement(name = "town")
    private List<TownDtoViewInfo> towns;

    public List<TownDtoViewInfo> getTowns() {
        return towns;
    }

    public void setTowns(List<TownDtoViewInfo> towns) {
        this.towns = towns;
    }
}
