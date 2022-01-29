package ch.sascha.tbz.departments;

import ch.sascha.tbz.abstracts.Department;

//birth department
public class Maternity extends Department {

    public Maternity() {
    }

    public Maternity(int max_patient_count, int employeeCount, int activeDoctorsAvailable) {
        super(max_patient_count, employeeCount, activeDoctorsAvailable);
    }

}
