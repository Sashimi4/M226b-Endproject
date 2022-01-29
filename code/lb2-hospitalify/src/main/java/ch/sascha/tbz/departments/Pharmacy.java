package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;

//outpatient and storage department
public class Pharmacy extends Department {

    public Pharmacy() {
    }

    public Pharmacy(int max_patient_count, int employeeCount, int activeDoctorsAvailable) {
        super(max_patient_count, employeeCount, activeDoctorsAvailable);
    }

}
