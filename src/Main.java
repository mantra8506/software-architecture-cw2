import data.AppointmentFileHandler;
import java.util.List;
import model.Appointment;

public class Main {
    public static void main(String[] args) {

        List<Appointment> appointments = AppointmentFileHandler.loadAppointments();

        for (Appointment a : appointments) {
            System.out.println(a.getStatus());
        }
    }
}
