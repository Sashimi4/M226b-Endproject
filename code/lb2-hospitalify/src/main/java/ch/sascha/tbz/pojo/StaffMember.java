package ch.sascha.tbz.pojo;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.data.entity.Person;

public class StaffMember extends Person{

    private Department department;

    public StaffMember() {}

    public StaffMember(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
