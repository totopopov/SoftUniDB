package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Todor Popov using Lenovo on 22.7.2017 г. at 2:32.
 */

@Entity
@Table(name = "room_types")
public class RoomType {

    private String roomType;
    private String notes;

    @Id
    @Column(name = "room_type")
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
