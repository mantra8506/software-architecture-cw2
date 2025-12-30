package model;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String patientId;
    private String name;
    private String dateOfBirth;
    private String nhsNumber;
    private String contactDetails;

    // COMPOSITION: Patient owns MedicalRecord
    private MedicalRecord medicalRecord;

    // MULTIPLICITY: One patient → many appointments & prescriptions
    private List<Appointment> appointments;
    private List<Prescription> prescriptions;

    public Patient(String patientId, String name, String dateOfBirth,
                   String nhsNumber, String contactDetails) {

        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nhsNumber = nhsNumber;
        this.contactDetails = contactDetails;

        this.appointments = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Composition setter (created & updated by system/GP)
    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    

    public String getName() {
        return name;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public String getContactDetails() {
        return contactDetails;
    }
}
