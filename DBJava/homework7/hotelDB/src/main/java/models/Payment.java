package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 22.7.2017 г. at 2:44.
 */
@Entity
@Table(name = "payments")
public class Payment {

    private Long id;
    private Date paymentDate;
    private Customer customer;
    private Date firstDateOccupied;
    private Date lastDateOccupied;
    private Integer TotalDays;
    private BigDecimal amountCharged;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal payemntTotal;
    private String notes;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    @Column(name = "paymenet_date")
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @ManyToOne
    @JoinColumn(name = "account_number",referencedColumnName = "accountNumer")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "first_date_occupied")
    public Date getFirstDateOccupied() {
        return firstDateOccupied;
    }

    public void setFirstDateOccupied(Date firstDateOccupied) {
        this.firstDateOccupied = firstDateOccupied;
    }
    @Column(name = "last_date_occupied")
    public Date getLastDateOccupied() {
        return lastDateOccupied;
    }

    public void setLastDateOccupied(Date lastDateOccupied) {
        this.lastDateOccupied = lastDateOccupied;
    }
    @Column(name = "total_days")
    public Integer getTotalDays() {
        return TotalDays;
    }

    public void setTotalDays(Integer totalDays) {
        TotalDays = totalDays;
    }

    @Column(name = "amount_charged")
    public BigDecimal getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(BigDecimal amountCharged) {
        this.amountCharged = amountCharged;
    }

    @Column(name = "tax_rate")
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Column(name = "tax_amount")
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    @Column(name = "payment_total")
    public BigDecimal getPayemntTotal() {
        return payemntTotal;
    }

    public void setPayemntTotal(BigDecimal payemntTotal) {
        this.payemntTotal = payemntTotal;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
