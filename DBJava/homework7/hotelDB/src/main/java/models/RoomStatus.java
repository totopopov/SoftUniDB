package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 22.7.2017 г. at 2:30.
 */
@Entity
@Table(name = "room_status")
public class RoomStatus {

    private String roomStatus;
    private String notes;

    @Id
    @Column(name = "room_status")
    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
