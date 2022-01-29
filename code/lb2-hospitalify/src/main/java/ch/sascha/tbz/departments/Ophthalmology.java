package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;
//ear department
public class Ophthalmology extends Department {

    public Ophthalmology() {
    }

    public Ophthalmology(int max_patient_count, int employeeCount, int activeDoctorsAvailable) {
        super(max_patient_count, employeeCount, activeDoctorsAvailable);
    }
}
