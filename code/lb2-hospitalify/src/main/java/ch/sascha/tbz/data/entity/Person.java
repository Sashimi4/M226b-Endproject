package ch.sascha.tbz.data.entity;

import ch.sascha.tbz.abstracts.AbstractEntity;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * ! needs to also implement observable to see if a name or something has changed
 */
@Entity
@Table(name = "person")
public class Person extends AbstractEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    private String phone;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "employment_id")
    private Employment employment_id;

    /**
     * create new person and blank out form when using
     */
    public Person() {}

    /**
     * Static binding
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param dateOfBirth
     * @param employment_id
     */
    public Person(String firstName, String lastName, String email, String phone, LocalDate dateOfBirth, Employment employment_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.employment_id = employment_id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Employment getEmployment_id() {
        return employment_id;
    }
    public void setEmployment_id(Employment employment_id) {
        this.employment_id = employment_id;
    }
}
