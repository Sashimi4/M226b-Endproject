package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;

//brain and studies department
public class Neurology extends Department {

    public Neurology() {
    }

    public Neurology(int max_patient_count, int employeeCount, int activeDoctorsAvailable) {
        super(max_patient_count, employeeCount, activeDoctorsAvailable);
    }
}
