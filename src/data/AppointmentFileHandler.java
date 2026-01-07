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
            br.readLine(); // skip CSV header

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                // ✅ Map CSV columns correctly
                String appointmentId = values[0];
                String patientId = values[1];
                String clinicianId = values[2];
                String date = values[3];
                String status = values[4];
                String reason = values[5];

                Appointment appointment = new Appointment(
                        appointmentId,
                        patientId,
                        clinicianId,
                        date,
                        status,
                        reason
                );

                appointments.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointments;
    }
}
