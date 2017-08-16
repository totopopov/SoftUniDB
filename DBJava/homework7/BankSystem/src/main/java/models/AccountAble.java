package models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 1:15.
 */
public interface AccountAble {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long getId();

    void setId(Long id);

    @Column(name = "account_number")
    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    BigDecimal getBalance();

    void setBalance(BigDecimal balance);

    void depositMoney(BigDecimal money);

    void withdrawMoney(BigDecimal money);

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    UserAble getUser();

    void setUser(UserAble user);
}
