package models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 0:22.
 */

@Entity
@Table(name = "patients")
public class Patient {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Date dateOfBirth;
    private Boolean medicalInsurance;
    private Set<Visitation> visitations;
    private Set<Diagnose> diagnosess;
    private Set<PrescibedMedication> prescibedMedications;

    public Patient() {

    }

    public Patient(String firstName, String lastName, String address, String email, Date dateOfBirth, Boolean medicalInsurance) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
        this.setMedicalInsurance(medicalInsurance);
        this.visitations = new HashSet<>();
        this.diagnosess = new HashSet<>();
        this.prescibedMedications = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length()>255){
            throw new IllegalArgumentException("First name too long");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length()>255){
            throw new IllegalArgumentException("Last name too long");
        }
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length()>255){
            throw new IllegalArgumentException("Address too long");
        }
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.length()>255 ){
            throw new IllegalArgumentException("Email too long");
        }
        if (!email.matches("[a-zA-Z0-9]+([(\\.\\-_][a-zA-Z0-9]+)*@[a-zA-Z]+(\\.[a-zA-Z]+)+")){
            throw new IllegalArgumentException("Email is Invalid");
        }

        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(Boolean medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    @OneToMany
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @ManyToMany
    @JoinTable(name = "diagnoses_patients",joinColumns = @JoinColumn(name = "patient_id",referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name = "diagnoses_id",referencedColumnName = "id"))
    public Set<Diagnose> getDiagnosess() {
        return diagnosess;
    }

    public void setDiagnosess(Set<Diagnose> diagnosess) {
        this.diagnosess = diagnosess;
    }

    @ManyToMany
    @JoinTable(name = "prescribed_medication_Patients",joinColumns =@JoinColumn(name = "patient_id",referencedColumnName ="id")
    ,inverseJoinColumns = @JoinColumn(name = "prescribed_medication_id",referencedColumnName = "id"))
    public Set<PrescibedMedication> getPrescibedMedications() {
        return prescibedMedications;
    }

    public void setPrescibedMedications(Set<PrescibedMedication> prescibedMedications) {
        this.prescibedMedications = prescibedMedications;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", medicalInsurance=" + medicalInsurance +
                ", visitations=" + visitations +
                ", diagnosess=" + diagnosess +
                ", prescibedMedications=" + prescibedMedications +
                '}';
    }
}
