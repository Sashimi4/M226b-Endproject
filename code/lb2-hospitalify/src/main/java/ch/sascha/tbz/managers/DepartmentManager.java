package ch.sascha.tbz.managers;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.factories.DepartmentFactory;

import java.util.ArrayList;


public class DepartmentManager {

    //allows threads
    private final ArrayList<Department> departments;

    private final DepartmentFactory departmentFactory = new DepartmentFactory();

    public DepartmentManager() {
        this.departments = new ArrayList<>();
        defineDepartments(departments);
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void defineDepartments(ArrayList<Department> departments) {

        //this made be too hard-codey so have a look back at this
        departments.add(departmentFactory.getDepartment("neurology"));
        departments.add(departmentFactory.getDepartment("pharmacy"));
        departments.add(departmentFactory.getDepartment("maternity"));
        departments.add(departmentFactory.getDepartment("cardiology"));
        departments.add(departmentFactory.getDepartment("a_e"));
        departments.add(departmentFactory.getDepartment("operationtheatre"));
        departments.add(departmentFactory.getDepartment("ophthalmology"));
    }
}
