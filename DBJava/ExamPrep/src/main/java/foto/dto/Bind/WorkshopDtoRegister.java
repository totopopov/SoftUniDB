package foto.dto.Bind;


import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:27.
 */


@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopDtoRegister {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "start-date")
    private Date startDate;

    @XmlAttribute(name = "end-date")
    private Date endDate;

    @XmlAttribute(name = "location")
    private String location;

    @XmlAttribute(name = "price")
    private BigDecimal pricePerParticipant;

    @XmlElement(name = "trainer")
    private String trainerString;

    @XmlElementWrapper(name = "participants")
    @XmlElement(name = "participant")
    private Set<PotographerDtoFullName> participantsString;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public String getTrainerString() {
        return trainerString;
    }

    public void setTrainerString(String trainerString) {
        this.trainerString = trainerString;
    }

    public Set<PotographerDtoFullName> getParticipantsString() {
        return participantsString;
    }

    public void setParticipantsString(Set<PotographerDtoFullName> participantsString) {
        this.participantsString = participantsString;
    }
}
