package view;

import controller.PatientController;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Patient;

public class PatientsPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;
    private PatientController controller;

    public PatientsPanel() {

        controller = new PatientController();
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "DOB", "NHS Number"}, 0
        );

        table = new JTable(model);

        JButton loadBtn = new JButton("Load");
        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");

        loadBtn.addActionListener(e -> loadPatients());
        addBtn.addActionListener(e -> addPatient());
        deleteBtn.addActionListener(e -> deletePatient());

        JPanel top = new JPanel();
        top.add(loadBtn);
        top.add(addBtn);
        top.add(deleteBtn);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadPatients() {
        model.setRowCount(0);
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

    private void addPatient() {

        JTextField nameField = new JTextField();
        JTextField dobField = new JTextField();
        JTextField nhsField = new JTextField();
        JTextField contactField = new JTextField();
    
        Object[] form = {
            "Name:", nameField,
            "Date of Birth (YYYY-MM-DD):", dobField,
            "NHS Number:", nhsField,
            "Contact:", contactField
        };
    
        int result = JOptionPane.showConfirmDialog(
                this, form, "Add Patient",
                JOptionPane.OK_CANCEL_OPTION
        );
    
        if (result != JOptionPane.OK_OPTION) return;
    
        Patient patient = new Patient(
                "P" + System.currentTimeMillis(),
                nameField.getText(),
                dobField.getText(),
                nhsField.getText(),
                contactField.getText()
        );
    
        controller.addPatient(patient);
        loadPatients();
    }
    

    private void deletePatient() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            controller.deletePatient(row);
            loadPatients();
        }
    }
}
