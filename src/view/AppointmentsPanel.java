package view;

import controller.AppointmentController;
import model.Appointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AppointmentsPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public AppointmentsPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Patient", "Clinician", "Date", "Status"}, 0);

        table = new JTable(model);

        JButton loadBtn = new JButton("Load Appointments");
        loadBtn.addActionListener(e -> loadAppointments());

        add(loadBtn, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadAppointments() {
        model.setRowCount(0);

        List<Appointment> list = AppointmentController.getAllAppointments();
        for (Appointment a : list) {
            model.addRow(new Object[]{
                    a.getAppointmentId(),
                    a.getPatientId(),
                    a.getClinicianId(),
                    a.getDate(),
                    a.getStatus()
            });
        }
    }
}
