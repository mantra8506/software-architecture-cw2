package model;

public class Appointment {

    private String appointmentId;
    private String date;
    private String reason;
    private String status;

    public Appointment(String appointmentId, String date, String reason, String status) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.reason = reason;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
