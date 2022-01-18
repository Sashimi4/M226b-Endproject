package ch.sascha.tbz;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.departments.Neurology;

public class Starter {

    public static void main(String[] args) {
        DepartmentFactory departmentFactory = new DepartmentFactory();
        Department neurology = departmentFactory.getDepartment("neurology");

        neurology.setEmployeeCount(8);

        System.out.println(neurology.getEmployeeCount());
    }
}
