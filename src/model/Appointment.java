package model;

public class Appointment {

    private String appointmentId;
    private String patientId;
    private String clinicianId;
    private String date;
    private String status;
    private String reason;

    public Appointment(String appointmentId,
                       String patientId,
                       String clinicianId,
                       String date,
                       String status,
                       String reason) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.date = date;
        this.status = status;
        this.reason = reason;
    }

    // ✅ REQUIRED GETTERS (MVC)
    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getClinicianId() {
        return clinicianId;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}
