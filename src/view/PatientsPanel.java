package view;

import controller.PatientController;
import model.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PatientsPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public PatientsPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "DOB", "NHS Number"}, 0);
        table = new JTable(model);

        JButton loadBtn = new JButton("Load Patients");
        loadBtn.addActionListener(e -> loadPatients());

        add(loadBtn, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadPatients() {
        model.setRowCount(0);
        PatientController controller = new PatientController();
        List<Patient> patients = controller.getAllPatients();

        for (Patient p : patients) {
            model.addRow(new Object[]{
                    p.getPatientId(),
                    p.getName(),
                    p.getDateOfBirth(),
                    p.getNhsNumber()
            });
        }
    }
}
