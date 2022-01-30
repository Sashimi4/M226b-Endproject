package ch.sascha.tbz.pojo;

import ch.sascha.tbz.data.entity.Person;


//Differs from person class to hide who is a patient and keep that information confidential
public class Patient extends Person {

    private PatientType patientType;


    public Patient() {}

    public Patient(PatientType patientType) {
        this.patientType = patientType;
    }


}
