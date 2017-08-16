package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 20:17.
 */
@Entity
//@DiscriminatorValue("bank account") for SingleTable
@Table(name = "bank_account")
@PrimaryKeyJoinColumn(name = "number")
public class BankAccount extends BillingDetail {

    private String bankName;
    private String SWIFTCode;



    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "swift_code")
    public String getSWIFTCode() {
        return SWIFTCode;
    }

    public void setSWIFTCode(String SWIFTCode) {
        this.SWIFTCode = SWIFTCode;
    }
}
