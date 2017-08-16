package gamestore.app.entities;

import gamestore.app.entities.enums.UserRole;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 1.8.2017 г. at 14:59.
 */

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String email;
    private String password;
    private String fullName;
    private UserRole userRole;

    private Set<Game> gamesInCart;
    private Set<Game> boughtGames;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "email",unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "users_games_cart",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "game_id",referencedColumnName = "id"))
    public Set<Game> getGamesInCart() {
        return gamesInCart;
    }

    public void setGamesInCart(Set<Game> gamesInCart) {
        this.gamesInCart = gamesInCart;
    }

    @ManyToMany
    @JoinTable(name = "users_games_bought",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id",referencedColumnName = "id"))
    public Set<Game> getBoughtGames() {
        return boughtGames;
    }

    public void setBoughtGames(Set<Game> boughtGames) {
        this.boughtGames = boughtGames;
    }
}
