package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.pojo.StaffMember;

import java.util.Collection;

//heart department
public class Cardiology extends Department {

    public Cardiology() {
    }

    public Cardiology(int max_patient_count, int employeeCount, Collection<StaffMember> employees) {
        super(max_patient_count, employeeCount, employees);
    }

}
