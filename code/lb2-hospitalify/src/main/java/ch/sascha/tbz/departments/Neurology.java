package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.pojo.StaffMember;

import java.util.Collection;

//brain and studies department
public class Neurology extends Department {

    public Neurology() {
    }

    public Neurology(int max_patient_count, int employeeCount, Collection<StaffMember> employees) {
        super(max_patient_count, employeeCount, employees);
    }
}
