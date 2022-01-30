package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.pojo.StaffMember;
import java.util.Collection;

/**
 * Subclass of Departments
 */
public class Ophthalmology extends Department {

    /**
     * Empty constructor
     */
    public Ophthalmology() {
    }

    /**
     * Constructor with parameters.
     * @param max_patient_count     int value representing max amount of patients
     * @param employeeCount         int employee count
     * @param employees             Collection objects such as ArrayLists, Lists, Sets usw.
     */
    public Ophthalmology(int max_patient_count, int employeeCount, Collection<StaffMember> employees) {
        super(max_patient_count, employeeCount, employees);
    }
}
