package foto.dto.Bind;


import foto.dto.View.PhotographerDtoViewBasic;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:27.
 */


@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopDtoRegisterAdapter {

    private String name;

    private Date startDate;

    private Date endDate;

    private String location;

    private BigDecimal pricePerParticipant;

    private PhotographerDtoViewBasic trainer;

    private Set<PhotographerDtoViewBasic> participants;

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

    public PhotographerDtoViewBasic getTrainer() {
        return trainer;
    }

    public void setTrainer(PhotographerDtoViewBasic trainer) {
        this.trainer = trainer;
    }

    public Set<PhotographerDtoViewBasic> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<PhotographerDtoViewBasic> participants) {
        this.participants = participants;
    }
}
