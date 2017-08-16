package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 23:04.
 */
@Entity
@Table(name = "savings_account")
public class SavingsAccount extends Account {

    private BigDecimal interestRate;

    public SavingsAccount() {
    }

    public SavingsAccount(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Column(name = "interest_rate")
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest(BigDecimal interestRate){
        this.interestRate=this.interestRate.add(interestRate);
    }
}
