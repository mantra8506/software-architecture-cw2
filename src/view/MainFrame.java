package view;

import controller.ReferralController;
import javax.swing.*;

public class MainFrame extends JFrame {

    private ReferralController referralController;   // ✅ MOVE HERE

    public MainFrame() {
        setTitle("Healthcare Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ReferralController referralController = new ReferralController();


        JTabbedPane tabs = new JTabbedPane();

        tabs.add("Patients", new PatientsPanel());
        tabs.add("Clinicians", new CliniciansPanel());
        tabs.add("Appointments", new AppointmentsPanel());
        tabs.add("Prescriptions", new PrescriptionsPanel());
        tabs.add("Referrals", new ReferralsPanel(referralController));
        

        add(tabs);
        setVisible(true);
    }
}
