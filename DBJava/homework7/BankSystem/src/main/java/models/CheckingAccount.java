package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 23:04.
 */
@Entity
@Table(name = "checking_account")
public class CheckingAccount extends Account {

    private BigDecimal fee;

    public CheckingAccount() {
    }

    public CheckingAccount(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public void deductFee(BigDecimal fee){
        this.fee=this.fee.subtract(fee);
    }
}
