package ch.sascha.tbz;

import ch.sascha.tbz.data.entity.Person;

//Differs from person class to hide who is a patien and keep that information confidential
public class Patient extends Person {

    private PatientType patientType;
    private Person personInformation;

    public Patient() {}

    public Patient(PatientType patientType, Person personInformation) {
        super();
        this.patientType = patientType;
    }


    public PatientType getPatientType() {
        return patientType;
    }
    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }
}
