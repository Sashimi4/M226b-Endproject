package ch.sascha.tbz.data.entity;

import ch.sascha.tbz.abstracts.AbstractEntity;
import javax.persistence.*;
import java.util.List;

/**
 * Object annotated by Entity for representing an Employment/Job title
 * Is annotated with @Entity, meaning is made into a Table
 */
@Entity
@Table(name = "employment")
public class Employment extends AbstractEntity{

    /**
     * List with 'Person' generics for containing foreign key references
     * One to many relationship to Person
     */
    @OneToMany(mappedBy = "employment_id")
    private List<Person> people;

    /**
     * String representing a job title such as nurse, doctor, cleaning crew, etc.
     */
    private String employment;

    /**
     * Getter for retrieving employment instance
     * @return      employment String object
     */
    public String getEmployment() {
        return employment;
    }

    /**
     * Setter for reassigning the employment String object
     * @param employment        String object for employment instance
     */
    public void setEmployment(String employment) {
        this.employment = employment;
    }
}
