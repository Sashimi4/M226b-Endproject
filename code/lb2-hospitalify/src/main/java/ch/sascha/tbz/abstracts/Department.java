package ch.sascha.tbz.abstracts;

public abstract class Department {

    //1. Contains a list of some sort with every active doctor working there
    //2. Patient counter + max amount of patient able to be held
    //3.

    //no use
    public Department() {
    }

    private int employeeCount;
    //no clue if this is needed
    private int activeDoctorsAvailable;


    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
}
