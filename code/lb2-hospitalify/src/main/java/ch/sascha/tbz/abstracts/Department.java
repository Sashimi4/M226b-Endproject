package ch.sascha.tbz.abstracts;

public abstract class Department {

    //1. Contains a list of some sort with every active doctor working there
    //2. Patient counter + max amount of patient able to be held
    //3.

    //no use
    public Department() {
    }

    private int max_patient_count;

    private int employeeCount;

    //no clue if this is needed
    private int activeDoctorsAvailable;

    public Department(int max_patient_count, int employeeCount, int activeDoctorsAvailable) {
        this.max_patient_count = max_patient_count;
        this.employeeCount = employeeCount;
        this.activeDoctorsAvailable = activeDoctorsAvailable;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getMax_patient_count() {
        return max_patient_count;
    }

    public void setMax_patient_count(int max_patient_count) {
        this.max_patient_count = max_patient_count;
    }

    public int getActiveDoctorsAvailable() {
        return activeDoctorsAvailable;
    }

    public void setActiveDoctorsAvailable(int activeDoctorsAvailable) {
        this.activeDoctorsAvailable = activeDoctorsAvailable;
    }
}
