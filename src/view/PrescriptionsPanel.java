package view;

import controller.PrescriptionController;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Prescription;

public class PrescriptionsPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public PrescriptionsPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Medication", "Dosage", "Collected"}, 0);

        table = new JTable(model);

        JButton loadBtn = new JButton("Load");
        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");

        JPanel buttons = new JPanel();
        buttons.add(loadBtn);
        buttons.add(addBtn);
        buttons.add(deleteBtn);

        loadBtn.addActionListener(e -> loadPrescriptions());
        addBtn.addActionListener(e -> addPrescription());
        deleteBtn.addActionListener(e -> deletePrescription());

        add(buttons, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadPrescriptions() {
        model.setRowCount(0);
        List<Prescription> list = PrescriptionController.getAllPrescriptions();
        for (Prescription p : list) {
            model.addRow(new Object[]{
                    p.getPrescriptionId(),
                    p.getMedication(),
                    p.getDosage(),
                    p.isCollected()
            });
        }
    }

    private void addPrescription() {
        String id = JOptionPane.showInputDialog("Prescription ID:");
        String med = JOptionPane.showInputDialog("Medication:");
        String dose = JOptionPane.showInputDialog("Dosage:");

        Prescription p = new Prescription(id, med, dose,
                "Manual Entry", false);

        PrescriptionController.addPrescription(p);
        loadPrescriptions();
    }

    private void deletePrescription() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first");
            return;
        }
        PrescriptionController.deletePrescription(row);
        loadPrescriptions();
    }
}
