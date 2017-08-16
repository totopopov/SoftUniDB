package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:09.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "carige_type",discriminatorType = DiscriminatorType.STRING)
public abstract class Carige {
    private Long id;
    private Integer seatsCapacity;
    private Train train;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(Integer seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }

    @ManyToOne
    @JoinColumn(name = "train_id",referencedColumnName = "id")
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
