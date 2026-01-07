package controller;

import data.AppointmentFileHandler;
import model.Appointment;

import java.util.List;

public class AppointmentController {

    public static List<Appointment> getAllAppointments() {
        return AppointmentFileHandler.loadAppointments();
    }
}
