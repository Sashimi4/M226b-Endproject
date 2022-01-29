package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;

//urgent emergencies and then later swapped to their respective department
public class A_E extends Department {

    public A_E(int max_patient_count, int employeeCount, int activeDoctorsAvailable) {
        super(max_patient_count, employeeCount, activeDoctorsAvailable);
    }

    public A_E() {
    }
}
