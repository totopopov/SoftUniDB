package foto.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:27.
 */

@Entity
@Table(name = "workshops")
public class Workshop {

    private Long id;

    private String name;

    private Date startDate;

    private Date endDate;

    private String location;

    private BigDecimal pricePerParticipant;

    private Photographer trainer;

    private Set<Photographer> participants;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(nullable = false)
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

    @NotNull
    @Column(nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NotNull
    @Column(nullable = false, name = "price_per_participant")
    public BigDecimal getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "trainer_id",referencedColumnName = "id",nullable = false)
    public Photographer getTrainer() {
        return trainer;
    }

    public void setTrainer(Photographer trainer) {
        this.trainer = trainer;
    }

    @ManyToMany
    @JoinTable(name = "workshop_photographers",joinColumns = @JoinColumn(name = "workshop_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "photographer_id",referencedColumnName = "id"))
    public Set<Photographer> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Photographer> participants) {
        this.participants = participants;
    }
}
