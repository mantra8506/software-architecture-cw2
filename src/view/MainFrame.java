package view;

import controller.PrescriptionController;
import controller.ReferralController;
import model.Prescription;
import model.Referral;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {

    private JTextArea outputArea;
    private PrescriptionController prescriptionController;
    private ReferralController referralController;

    public MainFrame() {

        prescriptionController = new PrescriptionController();
        referralController = new ReferralController();

        setTitle("Healthcare Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Buttons
        JButton loadPrescriptionsBtn = new JButton("Load Prescriptions");
        JButton createReferralBtn = new JButton("Create Referral");

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel topPanel = new JPanel();
        topPanel.add(loadPrescriptionsBtn);
        topPanel.add(createReferralBtn);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button actions
        loadPrescriptionsBtn.addActionListener(e -> loadPrescriptions());
        createReferralBtn.addActionListener(e -> createReferral());

        setVisible(true);
    }

    private void loadPrescriptions() {
        outputArea.setText("");
        List<Prescription> prescriptions = prescriptionController.getAllPrescriptions();

        for (Prescription p : prescriptions) {
            outputArea.append(
                    p.getMedication() + " | Collected: " + p.isCollected() + "\n"
            );
        }
    }

    private void createReferral() {
        Referral referral = new Referral(
                "R100",
                "P001",
                "GP Surgery A",
                "City Hospital",
                "Urgent",
                "GUI generated referral."
        );

        referralController.createReferral(referral);
        outputArea.append("\nReferral created successfully.\n");
    }
}
