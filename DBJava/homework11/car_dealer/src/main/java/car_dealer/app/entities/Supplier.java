package car_dealer.app.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 7.8.2017 г. at 21:03.
 */

@Entity
@Table(name = "suppliers")
public class Supplier {

    private Long id;
    private String name;
    private Boolean Imported;
    private Set<Part> parts;

    public Supplier() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column( nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_imported", nullable = false)
    public Boolean getImported() {
        return Imported;
    }

    public void setImported(Boolean imported) {
        Imported = imported;
    }

    @OneToMany(mappedBy = "supplier",targetEntity = Part.class)
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
