package view;

import controller.ClinicianController;
import model.Clinician;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CliniciansPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public CliniciansPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Specialty", "Facility"}, 0
        );
        table = new JTable(model);

        JButton loadBtn = new JButton("Load Clinicians");
        loadBtn.addActionListener(e -> loadClinicians());

        add(loadBtn, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadClinicians() {
        model.setRowCount(0);
        List<Clinician> list = ClinicianController.getAllClinicians();

        for (Clinician c : list) {
            model.addRow(new Object[]{
                    c.getClinicianId(),
                    c.getName(),
                    c.getSpecialty(),
                    c.getFacility()
            });
        }
    }
}
