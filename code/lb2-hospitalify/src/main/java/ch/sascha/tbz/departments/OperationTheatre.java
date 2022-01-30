package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.pojo.StaffMember;

import java.util.Collection;

//surgeons and equipment department
public class OperationTheatre extends Department {

    public OperationTheatre() {
    }

    public OperationTheatre(int max_patient_count, int employeeCount, Collection<StaffMember> employees) {
        super(max_patient_count, employeeCount, employees);
    }
}
