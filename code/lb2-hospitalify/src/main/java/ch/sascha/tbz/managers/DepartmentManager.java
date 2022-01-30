package ch.sascha.tbz.managers;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.factories.DepartmentFactory;

import java.util.ArrayList;

/**
 * This class represents a manager object which looks over departments
 */
public class DepartmentManager {

    /**
     * ArrayList containing all relevant departments
     */
    private final ArrayList<Department> departments;

    /**
     * Department Factory instance for creating departments and keeping abstraction in the code
     */
    private final DepartmentFactory departmentFactory;

    /**
     * Constructor for instantiating the department ArrayList and the department factory.
     */
    public DepartmentManager() {
        this.departments = new ArrayList<>();
        this.departmentFactory = new DepartmentFactory();
        generateDepartments();
    }

    /**
     * Getter method for fetching ArrayList object from this instance.
     * @return      ArrayList containg all departments
     */
    public ArrayList<Department> getDepartments() {
        return departments;
    }

    /**
     * Geter method for fetching the department factory instance contained in this object.
     * @return      department factory instance
     */
    public DepartmentFactory getDepartmentFactory() {
        return departmentFactory;
    }

    /**
     * Generate every type of department when instantiated.
     * Mainly serves demonstration use and can be removed when the user can create departments
     */
    private void generateDepartments() {
        departments.add(departmentFactory.getDepartment("a_e"));
        departments.add(departmentFactory.getDepartment("cardiology"));
        departments.add(departmentFactory.getDepartment("maternity"));
        departments.add(departmentFactory.getDepartment("neurology"));
        departments.add(departmentFactory.getDepartment("operationtheatre"));
        departments.add(departmentFactory.getDepartment("ophthalmology"));
        departments.add(departmentFactory.getDepartment("pharmacy"));
    }
}
