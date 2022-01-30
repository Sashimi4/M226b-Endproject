package ch.sascha.tbz.factories;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.departments.*;

/**
 * Factory pattern object for creating subclass departments such as Neurology etc.
 */
public class DepartmentFactory {

    /**
     * Initialises department subclasses using a factory pattern to keep abstraction.
     * @param departmentID      String of the department class name. Casing gets ignored.
     * @return                  Subclass of Department corresponding with the parameter given.
     */
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
