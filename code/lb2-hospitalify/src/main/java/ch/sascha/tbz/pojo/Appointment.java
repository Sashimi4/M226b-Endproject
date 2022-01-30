package ch.sascha.tbz.pojo;

import ch.sascha.tbz.abstracts.Department;
import ch.sascha.tbz.data.entity.Person;
import java.time.LocalDate;

/**
 * Appointment class which represents patient appointments between doctors.
 *
 * Is currently not is use.
 */
public class Appointment {

    /**
     * Patient object which represents the patient in subject.
     */
    private Person patient;

    /**
     * Staff member which represents the attending doctor.
     */
    private Person staffLead;

    /**
     * LocalDate object when the appointment takes place
     */
    private LocalDate appointmentDate;

    /**
     * Department object for specifying in which department the appointment is part of.
     */
    private Department department;

    /**
     * Empty Appointment constructor for creating appointments
     */
    public Appointment() {}

    /**
     * Appointment constructor for creating appointments.
     * @param patient               Patient object
     * @param staffLead             StaffMember object
     * @param appointmentDate       LocalDate appointment due date
     * @param department            Department in question
     */
    public Appointment(Person patient, Person staffLead, LocalDate appointmentDate, Department department) {
        this.patient = patient;
        this.staffLead = staffLead;
        this.appointmentDate = appointmentDate;
        this.department = department;
    }

    /**
     * Getter & Setter methods
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
