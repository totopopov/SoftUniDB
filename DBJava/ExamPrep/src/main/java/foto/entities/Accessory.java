package foto.entities;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:09.
 */

@Entity
@Table(name = "accessories")
public class Accessory {

    private Long id;

    private String name;

    private Photographer owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "photographer_id",referencedColumnName = "id")
    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }


}
