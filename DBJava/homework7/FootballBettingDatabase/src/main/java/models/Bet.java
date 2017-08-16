package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 19:14.
 */

@Entity
@Table(name = "bets")
public class Bet {
    private Long id;
    private BigDecimal betMoney;
    private Date date;
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
