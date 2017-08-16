package foto.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 19:51.
 */

@Entity
@Table(name = "lenses")
public class Lens {

    private Long id;

    private String make;

    private Integer focalLenght;

    private BigDecimal maxApreture;

    private String compatibleWith;

    private Photographer owner;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "focal_lenght")
    public Integer getFocalLenght() {
        return focalLenght;
    }

    public void setFocalLenght(Integer focalLenght) {
        this.focalLenght = focalLenght;
    }


    @Digits(integer = 64,fraction = 1)
    @Column(name = "max_aperture")
    public BigDecimal getMaxApreture() {
        return maxApreture;
    }

    public void setMaxApreture(BigDecimal maxApreture) {
        this.maxApreture = maxApreture;
    }

    @Column(name = "compatible_with")
    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    @ManyToOne()
    @JoinColumn(name = "photographer_id",referencedColumnName = "id")
    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }
}
