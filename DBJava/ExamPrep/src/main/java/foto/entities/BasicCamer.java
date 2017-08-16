package foto.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 19:54.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
public class BasicCamer {

    private Long id;

    private String make;
    private String model;
    private Boolean frame;
    private Integer minIso;
    private Integer maxIso;


    public BasicCamer() {
    }

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
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    @Column(nullable = false)
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

    @Min(value = 100)
    @NotNull
    @Column(nullable = false)
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
}
