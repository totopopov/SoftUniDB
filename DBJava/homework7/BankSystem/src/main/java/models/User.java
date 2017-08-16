package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 23:13.
 */

@Entity
@Table(name = "users")
public class User implements UserAble {
    private Long id;

    private String username;
    private String password;
    private String email;
    private Set<AccountAble> accountAbles;

    public User() {
    }

    public User(String username, String password, String email) {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setAccounts(new HashSet<>());
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        if (!username.matches("[a-zA-Z][a-zA-Z0-9]{2,}")){
            throw new IllegalArgumentException("Incorect username");
        }
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        if (!password.matches(""))
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @OneToMany(mappedBy ="user",targetEntity = Account.class,cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
    public Set<AccountAble> getAccounts() {
        return accountAbles;
    }

    @Override
    public void setAccounts(Set<AccountAble> accountAbles) {
        this.accountAbles = accountAbles;
    }


    @Override
    public void AddAccount(AccountAble accountAble) {
        this.accountAbles.add(accountAble) ;
    }

}
