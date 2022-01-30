package ch.sascha.tbz.pojo;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.data.entity.Person;

/**
 * Class extended from Person and represents a staff member working at the hospital.
 */
public class StaffMember extends Person{

    /**
     * Department object specifying in which department the staff member works in.
     */
    private Department department;

    /**
     * Empty Staff member constructor
     */
    public StaffMember() {}

    /**
     * Constructor for a staff member with defining the department.
     * @param department        Department object
     */
    public StaffMember(Department department) {
        this.department = department;
    }

    /**
     * Getter method for getting department field
     * @return      returns this instances department object.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets Department to a new instance.
     * @param department        Department object
     */
    public void setDepartment(Department department) {
        this.department = department;
    }
}
