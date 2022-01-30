package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.pojo.StaffMember;

import java.util.Collection;

//ear department
public class Ophthalmology extends Department {

    public Ophthalmology() {
    }

    public Ophthalmology(int max_patient_count, int employeeCount, Collection<StaffMember> employees) {
        super(max_patient_count, employeeCount, employees);
    }
}
