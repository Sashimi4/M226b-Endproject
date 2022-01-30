package ch.sascha.tbz.abstracts;

import ch.sascha.tbz.pojo.StaffMember;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Abstract class containing logic for all departments. Gets extended to all department types and serves the purpose oh inheritance.
 */
public abstract class Department {

    /**
     * Empty constructor
     */
    public Department() {
    }

    /**
     * Int representing the maximal size of the department.
     */
    private int max_patient_count;

    /**
     * Int representing the amount of employees under the department
     * which can get calculated by ArrayList employees size.
     */
    private int employeeCount;

    /**
     * ArrayList of staff members containing all employees under that department.
     */
    private ArrayList<StaffMember> employees;

    /**
     * Constructor for creating Department
     * @param max_patient_count     int value representing max amount of patients
     * @param employeeCount         int employee count
     * @param employees             Collection objects such as ArrayLists, Lists, Sets usw.
     */
    public Department(int max_patient_count, int employeeCount, Collection<StaffMember> employees) {
        this.max_patient_count = max_patient_count;
        this.employeeCount = employeeCount;
        this.employees = (ArrayList<StaffMember>) employees;
    }

    /**
     * Overridden toString() method for displaying the subclasses name
     * @return      String of the subclass name
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    /**
     * Getter for employeeCount instance
     * @return      int for a employeeCount location
     */
    public int getEmployeeCount() {
        return employeeCount;
    }
    /**
     * Setter for reassigning the employeeCount instance
     * @param employeeCount        int object for employeeCount instance
     */
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
    /**
     * Getter for max_patient_count instance
     * @return      int for a max_patient_count location
     */
    public int getMax_patient_count() {
        return max_patient_count;
    }
    /**
     * Setter for reassigning the max_patient_count instance
     * @param max_patient_count        int object for max_patient_count instance
     */
    public void setMax_patient_count(int max_patient_count) {
        this.max_patient_count = max_patient_count;
    }
    /**
     * Getter for employees instance
     * @return      ArrayList<StaffMember> for employees
     */
    public ArrayList<StaffMember> getEmployees() {
        return employees;
    }
    /**
     * Setter for reassigning the employees instance
     * @param employees        ArrayList<StaffMember> object for employees instance
     */
    public void setEmployees(ArrayList<StaffMember> employees) {
        this.employees = employees;
    }
}
