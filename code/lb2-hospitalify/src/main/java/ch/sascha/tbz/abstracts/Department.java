package ch.sascha.tbz.abstracts;

import ch.sascha.tbz.data.entity.Person;
import ch.sascha.tbz.pojo.StaffMember;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Department {

    //1. Contains a list of some sort with every active doctor working there
    //2. Patient counter + max amount of patient able to be held
    //3.

    //no use
    public Department() {
    }

    private int max_patient_count;

    private int employeeCount;

    private ArrayList<StaffMember> employees;

    public Department(int max_patient_count, int employeeCount, Collection<StaffMember> employees) {
        this.max_patient_count = max_patient_count;
        this.employeeCount = employeeCount;
        this.employees = (ArrayList<StaffMember>) employees;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
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
    public ArrayList<StaffMember> getEmployees() {
        return employees;
    }
    public void setEmployees(ArrayList<StaffMember> employees) {
        this.employees = employees;
    }
}
