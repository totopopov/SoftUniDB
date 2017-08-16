package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 22.7.2017 г. at 2:52.
 */

@Entity
@Table(name = "occupancies")
public class Occupancy {

    private Long id;
    private Date dateOccupied;
    private Customer customer;
    private Set<Room> rooms;
    private BigDecimal rateApplied;
    private BigDecimal phoneCharges;
    private String notes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date_occupied")
    public Date getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(Date dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    @ManyToOne
    @JoinColumn(name = "account_number",referencedColumnName = "accountNumer")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToMany
    @JoinTable(name = "occupancies_rooms",
            joinColumns = @JoinColumn(name = "occupant_id",referencedColumnName ="id"),
    inverseJoinColumns = @JoinColumn(name = "room_number",referencedColumnName = "roomNumber"))
    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public BigDecimal getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(BigDecimal rateApplied) {
        this.rateApplied = rateApplied;
    }

    public BigDecimal getPhoneCharges() {
        return phoneCharges;
    }

    public void setPhoneCharges(BigDecimal phoneCharges) {
        this.phoneCharges = phoneCharges;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
