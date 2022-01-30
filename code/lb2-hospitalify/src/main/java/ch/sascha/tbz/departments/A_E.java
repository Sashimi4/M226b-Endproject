package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.pojo.StaffMember;

import java.util.Collection;

//urgent emergencies and then later swapped to their respective department
public class A_E extends Department {

    public A_E() {
    }

    public A_E(int max_patient_count, int employeeCount, Collection<StaffMember> employees) {
        super(max_patient_count, employeeCount, employees);
    }
}
