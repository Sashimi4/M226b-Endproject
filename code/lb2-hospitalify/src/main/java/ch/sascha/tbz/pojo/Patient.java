package ch.sascha.tbz.pojo;

import ch.sascha.tbz.data.entity.Person;

import java.util.ArrayList;

//Differs from person class to hide who is a patient and keep that information confidential
public class Patient extends Person {

    private PatientType patientType;
    private Person personInformation;

    //List of previous and upcoming appointments
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public Patient() {}

    public Patient(PatientType patientType, Person personInformation) {
        super(personInformation.getFirstName(), personInformation.getLastName(), personInformation.getEmail(), personInformation.getPhone(), personInformation.getDateOfBirth(), personInformation.getEmployment_id());
        this.patientType = patientType;
    }


    public PatientType getPatientType() {
        return patientType;
    }
    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }
    public Person getPersonInformation() {
        return personInformation;
    }
    public void setPersonInformation(Person personInformation) {
        this.personInformation = personInformation;
    }
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
}
