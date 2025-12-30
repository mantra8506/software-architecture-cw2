package view;

import controller.PrescriptionController;
import model.Prescription;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PrescriptionsPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public PrescriptionsPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Medication", "Dosage", "Collected"}, 0);

        table = new JTable(model);

        JButton loadBtn = new JButton("Load Prescriptions");
        loadBtn.addActionListener(e -> loadPrescriptions());

        add(loadBtn, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadPrescriptions() {
        model.setRowCount(0);

        List<Prescription> list = PrescriptionController.getAllPrescriptions();

        for (Prescription p : list) {
            model.addRow(new Object[]{
                    p.getPrescriptionId(),
                    p.getMedication(),
                    p.getDosage(),      // ✅ FIXED
                    p.isCollected()
            });
        }
    }
}
