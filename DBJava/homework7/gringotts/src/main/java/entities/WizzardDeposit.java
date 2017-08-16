package entities;


import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 21.7.2017 г. at 20:16.
 */
@Entity
@Table(name = "wizzard_deposits")
public class WizzardDeposit {

    private Long id;
    private String firstName;
    private String lastName;
    private String notes;
    private Integer age;
    private String magicWandCreator;
    private Integer magicWandSize;
    private String depositGroup;
    private Date depositStartDate;
    private BigDecimal depositAmount;
    private BigDecimal depositInterest;
    private BigDecimal depositCharge;
    private Date depositExpirationDate;
    private Boolean isDepositExpired;

    public WizzardDeposit() {
    }

    public WizzardDeposit(String firstName,
                          String lastName,
                          String notes,
                          Integer age,
                          String magicWandCreator,
                          Integer magicWandSize,
                          String depositGroup,
                          Date depositStartDate,
                          BigDecimal depositAmount,
                          BigDecimal depositInterest,
                          BigDecimal depositCharge,
                          Date depositExpirationDate,
                          Boolean isDepositExpired) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setNotes(notes);
        this.setAge(age);
        this.setMagicWandCreator(magicWandCreator);
        this.setMagicWandSize(magicWandSize);
        this.setDepositGroup(depositGroup);
        this.setDepositStartDate(depositStartDate);
        this.setDepositAmount(depositAmount);
        this.setDepositInterest(depositInterest);
        this.setDepositCharge(depositCharge);
        this.setDepositExpirationDate(depositExpirationDate);
        this.setDepositExpired(isDepositExpired);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name",columnDefinition = "VARCHAR(50)")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name",nullable = false,columnDefinition = "VARCHAR(60)")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Column(name = "notes", length = 1000,columnDefinition = "TEXT")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(name = "age",columnDefinition = "INT UNSIGNED NOT NULL")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "magoc_wand_creator",columnDefinition = "VARCHAR(100)")
    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    @Column(name ="magic_wand_size",columnDefinition = "INT UNSIGNED")
    public Integer getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(Integer magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    @Column(name = "deposit_group",columnDefinition = "VARCHAR(20)")
    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    @Column(name = "deposit_start_date")
    public Date getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(Date depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    @Column(name = "deposit_amount")
    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    @Column(name = "deposit_interest")
    public BigDecimal getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(BigDecimal depositInterest) {
        this.depositInterest = depositInterest;
    }

    @Column(name = "deposit_charge")
    public BigDecimal getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(BigDecimal depositCharge) {
        this.depositCharge = depositCharge;
    }


    @Column(name = "deposit_exipartion_date")
    public Date getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(Date depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    @Column(name = "is_deposit_expired")
    public Boolean getDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(Boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
