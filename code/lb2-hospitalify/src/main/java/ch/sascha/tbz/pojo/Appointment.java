package ch.sascha.tbz.pojo;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.data.entity.Person;
import java.time.LocalDate;

/**
 *
 */
public class Appointment {

    private Person patient;
    private Person staffLead;
    private LocalDate appointmentDate;
    private Department department;

    public Appointment() {}

    public Appointment(Person patient, Person staffLead, LocalDate appointmentDate, Department department) {
        this.patient = patient;
        this.staffLead = staffLead;
        this.appointmentDate = appointmentDate;
        this.department = department;
    }
    //contains a patient, department, date + time

    //if something is altered -> tell the observer to update things



    /**
     * Getter and Setter methods
     */
    public Person getPatient() {
        return patient;
    }
    public void setPatient(Person patient) {
        this.patient = patient;
    }
    public Person getStaffLead() {
        return staffLead;
    }
    public void setStaffLead(Person staffLead) {
        this.staffLead = staffLead;
    }
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
