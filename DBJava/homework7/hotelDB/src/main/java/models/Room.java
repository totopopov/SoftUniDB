package models;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 22.7.2017 г. at 2:33.
 */
@Entity
@Table(name = "rooms")
public class Room {

    private Long roomNumber;
    private RoomType roomType;
    private BedType bedType;
    private Integer rate;
    private RoomStatus roomStatus;
    private String notes;
    private Set<Occupancy> occupancies;

    @Id
    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    @ManyToOne
    @JoinColumn(name = "room_type",referencedColumnName = "room_type")
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    @ManyToOne
    @JoinColumn(name = "bed_type",referencedColumnName = "bed_type")
    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
    @ManyToOne
    @JoinColumn(name = "room_status",referencedColumnName = "room_status")
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @ManyToMany(mappedBy = "rooms",targetEntity = Occupancy.class)
    public Set<Occupancy> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(Set<Occupancy> occupancies) {
        this.occupancies = occupancies;
    }
}
