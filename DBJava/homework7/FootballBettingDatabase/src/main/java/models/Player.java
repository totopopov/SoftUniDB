package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 3:03.
 */

@Entity
@Table(name = "players")
public class Player {

    private Long id;
    private String name;
    private String squadNumber;
    private Team team;
    private Position position;
    private Boolean isInjured;


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

    @Column(name = "squad_number")
    public String getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(String squadNumber) {
        this.squadNumber = squadNumber;
    }

    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Boolean getInjured() {
        return isInjured;
    }

    public void setInjured(Boolean injured) {
        isInjured = injured;
    }
}
