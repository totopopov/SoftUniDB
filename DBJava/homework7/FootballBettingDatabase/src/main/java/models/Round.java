package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 2:39.
 */

@Entity
@Table(name = "rounds")
public class Round {

    private Long id;
    private String name;
    private Set<Game> games;


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

    @OneToMany(mappedBy = "round",targetEntity = Game.class)
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }


}
