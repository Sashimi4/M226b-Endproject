package ch.sascha.tbz.pojo;

import ch.sascha.tbz.data.entity.Person;

/**
 * Class extended from Person and represents a patient registered at the hospital.
 */
public class Patient extends Person {

    /**
     * Enum for defining the patient type
     */
    private PatientType patientType;

    /**
     * Patient constructor for creating patient objects.
     */
    public Patient() {}

    /**
     * Constructor with Enum type as parameter for creating Patients
     * @param patientType       PatientType enum object
     */
    public Patient(PatientType patientType) {
        this.patientType = patientType;
    }


}
