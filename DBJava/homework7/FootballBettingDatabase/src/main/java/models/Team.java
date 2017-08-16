package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 2:21.
 */

@Entity
@Table(name = "teams")
public class Team {

    private Long id;
    private String name;
    private byte[] logo;
    private String initials;
    private Color primaryKitColor;
    private Color SecondaryKitColor;
    private Town town;
    private BigDecimal budget;
    private Set<Player> players;


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

    public byte[] getLogo() {
        return logo;
    }

    @Column(columnDefinition = "LONGBLOB")
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @ManyToOne
    @JoinColumn(name = "primary_kit_color",referencedColumnName = "id")
    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color",referencedColumnName = "id")
    public Color getSecondaryKitColor() {
        return SecondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        SecondaryKitColor = secondaryKitColor;
    }

    @ManyToOne
    @JoinColumn(name = "town_id",referencedColumnName = "id")
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @OneToMany(mappedBy = "team",targetEntity = Player.class)
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
