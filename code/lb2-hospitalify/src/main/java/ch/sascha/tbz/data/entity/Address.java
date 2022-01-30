package ch.sascha.tbz.data.entity;

import ch.sascha.tbz.abstracts.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Spring boot entity for representing a table
 * The actual class doesn' have a big role in the rest of the program but is still necessary for completion sake.
 */
@Entity
public class Address extends AbstractEntity {

    /**
     * String object representing a street location
     */
    private String street;

    /**
     * String object representing a postal code
     */
    private String postalCode;

    /**
     * String object representing a city
     */
    private String city;

    /**
     * String object representing country
     */
    private String country;

    /**
     * List of Person objects for all foreign references.
     * One to Many relationship towards 'Person' object mapped by "address"
     */
    @OneToMany(mappedBy = "address")
    private List<Person> people;

    /**
     * Getter for street instance
     * @return      String for a street location
     */
    public String getStreet() {
        return street;
    }
    /**
     * Setter for reassigning the street instance
     * @param street        String object for street instance
     */
    public void setStreet(String street) {
        this.street = street;
    }
    /**
     * Getter for postal code instance
     * @return      String for a postal code
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * Setter for reassigning the postalCode instance
     * @param postalCode        String object for postalCode instance
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    /**
     * Getter for city instance
     * @return      String for a city location
     */
    public String getCity() {
        return city;
    }
    /**
     * Setter for reassigning the city instance
     * @param city        String object for city instance
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * Getter for country instance
     * @return      String for a country
     */
    public String getCountry() {
        return country;
    }
    /**
     * Setter for reassigning the country instance
     * @param country        String object for country instance
     */
    public void setCountry(String country) {
        this.country = country;
    }

}
