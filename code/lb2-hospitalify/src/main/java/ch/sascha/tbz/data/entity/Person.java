package ch.sascha.tbz.data.entity;

import ch.sascha.tbz.abstracts.AbstractEntity;
import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.pojo.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.*;

/**
 * Person entity annotated with @Entity, meaning it has a table.
 * Is the most prevalent entity object in this program
 */
@Entity
@Table(name = "person")
public class Person extends AbstractEntity {

    /**
     * String object representing a firstName
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * String object representing a lastName
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * String object representing an email
     */
    @Column(nullable = false)
    private String email;

    /**
     * String object representing a phone number
     */
    private String phone;

    /**
     * LocalDate object representing a date Of birth
     */
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    /**
     * Employment object representing a employment_id
     */
    @ManyToOne
    @JoinColumn(name = "employment_id")
    private Employment employment_id;

    /**
     * Address object representing an address
     */
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    /**
     * ArrayList containing all upcoming and previous appointments.
     * Sadly not in use yet.
     */
    private ArrayList<Appointment> appointments = new ArrayList<>();

    /**
     * Create new Person instance.
     * The reasoning of having a blank constructor, is for when the form gets reset. It should be populated by an empty Person object
     */
    public Person() {}

    /**
     * Constructor in case needed for views and Java backend, without use of databases.
     * @param firstName         String representing a firstname
     * @param lastName          String representing a lastname
     * @param email             String representing an email
     * @param phone             String representing a phone number
     * @param dateOfBirth       LocalDate representing a date of birth
     * @param employment_id     Employment representing a foreign key from the entity 'Employment'
     * @param address           Address representing a foreign key from the entity 'Address'
     */
    public Person(String firstName, String lastName, String email, String phone, LocalDate dateOfBirth, Employment employment_id, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.employment_id = employment_id;
        this.address = address;
    }

    /**
     * Getter for firstName instance
     * @return      String for a firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Setter for reassigning the firstName instance
     * @param firstName        String object for firstName instance
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Getter for lastName instance
     * @return      String for a lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Setter for reassigning the lastName instance
     * @param lastName        String object for lastName instance
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Getter for email instance
     * @return      String for a email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Setter for reassigning the email instance
     * @param email        String object for email instance
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Getter for phone instance
     * @return      String for a phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Setter for reassigning the phone instance
     * @param phone        String object for phone instance
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * Getter for dateOfBirth instance
     * @return      LocalDate for a dateOfBirth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * Setter for reassigning the dateOfBirth instance
     * @param dateOfBirth        LocalDate object for dateOfBirth instance
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * Getter for employment_id instance
     * @return      Employment for a employment_id
     */
    public Employment getEmployment_id() {
        return employment_id;
    }
    /**
     * Setter for reassigning the employment_id instance
     * @param employment_id        Employment object for employment_id instance
     */
    public void setEmployment_id(Employment employment_id) {
        this.employment_id = employment_id;
    }
    /**
     * Getter for address instance
     * @return      Address for a address
     */
    public Address getAddress() {
        return address;
    }
    /**
     * Setter for reassigning the address instance
     * @param address        Address object for address instance
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    /**
     * Getter for appointments instance
     * @return      ArrayList with Appointment generics for an appointments instance
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    /**
     * Setter for reassigning the appointments instance.
     * Sadly doesn't have a use as of yet.
     * @param appointments        ArrayList object for appointments instance
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
}
