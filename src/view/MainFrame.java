package view;

import javax.swing.*;
import controller.ReferralController;

public class MainFrame extends JFrame {

    private ReferralController referralController;   // ✅ MOVE HERE

    public MainFrame() {
        setTitle("Healthcare Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        referralController = new ReferralController(); // ✅ init here

        JTabbedPane tabs = new JTabbedPane();

        tabs.add("Patients", new PatientsPanel());
        tabs.add("Clinicians", new CliniciansPanel());
        tabs.add("Appointments", new AppointmentsPanel());
        tabs.add("Prescriptions", new PrescriptionsPanel());
        tabs.add("Referrals", new ReferralsPanel(referralController)); // ✅ pass controller

        add(tabs);
        setVisible(true);
    }
}
