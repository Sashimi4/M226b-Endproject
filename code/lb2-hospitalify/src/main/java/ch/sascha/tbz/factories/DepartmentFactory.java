package ch.sascha.tbz.factories;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.departments.*;

//department creation factory to hide logic and keep abstraction intact
//hides attributes I give as a parameter
public class DepartmentFactory {

    //alphabetically ordered
    public Department getDepartment(String departmentID) {
        if (departmentID == null) {
            return null;
        }
        if (departmentID.equalsIgnoreCase("A_E")) {
            return new A_E();
        }
        if (departmentID.equalsIgnoreCase("CARDIOLOGY")) {
            return new Cardiology();
        }
        if (departmentID.equalsIgnoreCase("NEUROLOGY")) {
            return new Neurology();
        }
        if (departmentID.equalsIgnoreCase("MATERNITY")) {
            return new Maternity();
        }
        if (departmentID.equalsIgnoreCase("OPERATIONTHEATRE")) {
            return new OperationTheatre();
        }
        if (departmentID.equalsIgnoreCase("OPHTHALMOLOGY")) {
            return new Ophthalmology();
        }
        if (departmentID.equalsIgnoreCase("PHARMACY")) {
            return new Pharmacy();
        }
        return null;
    }
}
