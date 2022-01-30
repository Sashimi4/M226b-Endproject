package ch.sascha.tbz.abstracts;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract class containing general methods which all other entities need: such as ID and object methods.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    /**
     * Integer for an entity and annotated for auto increment
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Retrieve id object from this instance
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for the field 'id'
     * @param id        Integer which represents and ID in an SQL table
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Overridden objects hashCode method for comparing objects using hash algorithms.
     * @return          Hash generated 4 bit Integer
     */
    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        }
        return super.hashCode();
    }

    /**
     * Overridden equals() method from Object.
     * @param obj       An object
     * @return          a Boolean if the object are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractEntity)) {
            return false; // null or other class
        }
        AbstractEntity other = (AbstractEntity) obj;

        if (id != null) {
            return id.equals(other.id);
        }
        return super.equals(other);
    }
}
