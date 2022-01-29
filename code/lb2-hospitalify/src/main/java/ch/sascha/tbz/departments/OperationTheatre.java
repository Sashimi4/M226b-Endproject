package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;

//surgeons and equipment department
public class OperationTheatre extends Department {

    public OperationTheatre() {
    }

    public OperationTheatre(int max_patient_count, int employeeCount, int activeDoctorsAvailable) {
        super(max_patient_count, employeeCount, activeDoctorsAvailable);
    }

}
