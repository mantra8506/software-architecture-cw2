package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;

public class AppointmentFileHandler {

    private static final String FILE_PATH = "datafiles/appointments.csv";

    public static List<Appointment> loadAppointments() {
        List<Appointment> appointments = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String appointmentId = values[0];
                String date = values[1];
                String reason = values[2];
                String status = values[3];

                Appointment appointment = new Appointment(
                        appointmentId, date, reason, status
                );

                appointments.add(appointment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointments;
    }
}
