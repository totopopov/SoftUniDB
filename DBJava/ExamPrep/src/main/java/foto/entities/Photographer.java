package foto.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 12.8.2017 г. at 20:07.
 */

@Entity
@Table(name = "photographers")
public class Photographer {


    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private BasicCamer primaryCamera;

    private BasicCamer secondaryCamera;

    private Set<Lens> lens;

    private Set<Accessory> accessory;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "first_name",nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Length(min = 3,max = 50)
    @NotNull
    @Column(name = "last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Pattern(regexp = "\\+\\d{1,3}\\/\\d{8,10}")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "primary_camera",referencedColumnName = "id",nullable = false)
    public BasicCamer getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(BasicCamer primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "secondary_camera",referencedColumnName = "id",nullable = false)
    public BasicCamer getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(BasicCamer secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    @OneToMany(mappedBy = "owner",targetEntity = Lens.class)
    public Set<Lens> getLens() {
        return lens;
    }

    public void setLens(Set<Lens> lens) {
        this.lens = lens;
    }

    @OneToMany(mappedBy = "owner",targetEntity = Accessory.class, cascade = CascadeType.PERSIST)
    public Set<Accessory> getAccessory() {
        return accessory;
    }

    public void setAccessory(Set<Accessory> accessory) {
        this.accessory = accessory;
    }

    @Transient
    public void addAccesorry(Accessory accessory){
        this.getAccessory().add(accessory);
    }
}
