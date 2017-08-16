package models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 1:47.
 */
public interface UserAble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long getId();

    void setId(Long id);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getEmail();

    void setEmail(String email);

    @OneToMany(mappedBy ="user",targetEntity = Account.class)
    Set<AccountAble> getAccounts();

    void setAccounts(Set<AccountAble> accountAbles);

    void AddAccount(AccountAble accountAble);

}
