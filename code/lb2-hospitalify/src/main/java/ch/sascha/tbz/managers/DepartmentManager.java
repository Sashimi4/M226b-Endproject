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
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
    public DepartmentFactory getDepartmentFactory() {
        return departmentFactory;
    }
}
