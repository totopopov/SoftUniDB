package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 20:14.
 */

@Entity
//@DiscriminatorValue("credit_card") for SingleTable
@Table(name = "credit_card")
@PrimaryKeyJoinColumn(name = "number")
public class CreditCard extends BillingDetail {
    private String cardType;
    private Integer expirationMonth;
    private Integer getExpirationYear;

    @Column(name = "card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_date")
    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year")
    public Integer getGetExpirationYear() {
        return getExpirationYear;
    }

    public void setGetExpirationYear(Integer getExpirationYear) {
        this.getExpirationYear = getExpirationYear;
    }
}
