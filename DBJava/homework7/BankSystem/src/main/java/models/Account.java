package models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 22:49.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account implements AccountAble {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private UserAble user;


    public Account() {
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public void depositMoney(BigDecimal money){
        this.balance=this.balance.add(money);
    }

    @Override
    public void withdrawMoney(BigDecimal money){
        this.balance=this.balance.subtract(money);
    }

    @Override
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public UserAble getUser() {
        return user;
    }

    @Override
    public void setUser(UserAble user) {
        this.user = user;
    }
}
