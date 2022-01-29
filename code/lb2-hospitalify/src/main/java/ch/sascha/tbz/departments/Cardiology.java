package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;

//heart department
public class Cardiology extends Department {

    public Cardiology() {
    }

    public Cardiology(int max_patient_count, int employeeCount, int activeDoctorsAvailable) {
        super(max_patient_count, employeeCount, activeDoctorsAvailable);
    }

}
