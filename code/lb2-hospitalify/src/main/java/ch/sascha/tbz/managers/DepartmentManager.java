package ch.sascha.tbz.managers;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.factories.DepartmentFactory;

import java.util.ArrayList;


public class DepartmentManager {

    //allows threads -> lieber ned
    private final ArrayList<Department> departments;
    private final DepartmentFactory departmentFactory;

    public DepartmentManager() {
        this.departments = new ArrayList<>();
        this.departmentFactory = new DepartmentFactory();
        generateDepartments();
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
    public DepartmentFactory getDepartmentFactory() {
        return departmentFactory;
    }

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
