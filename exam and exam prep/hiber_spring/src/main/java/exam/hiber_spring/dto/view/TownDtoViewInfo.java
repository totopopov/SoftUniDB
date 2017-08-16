package exam.hiber_spring.dto.view;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:18.
 */


@XmlAccessorType(XmlAccessType.FIELD)
public class TownDtoViewInfo {

    @XmlAttribute(name = "TownDtoViewInfo")
    private String name;

    @XmlAttribute(name = "population")
    private Integer population;

    @XmlAttribute(name = "town_clients")
    private Long clinets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Long getClinets() {
        return clinets;
    }

    public void setClinets(Long clinets) {
        this.clinets = clinets;
    }
}
