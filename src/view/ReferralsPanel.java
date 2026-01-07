package view;

import controller.ReferralController;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Referral;

public class ReferralsPanel extends JPanel {

    private ReferralController controller;
    private DefaultTableModel model;

    public ReferralsPanel(ReferralController controller) {

        this.controller = controller;
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
            new String[]{"Referral ID","Patient ID","From","To","Urgency","Summary","Status"}, 0
        );

        JTable table = new JTable(model);

        JButton createBtn = new JButton("Create Referral");
        JButton completeBtn = new JButton("Complete Referral");
        JButton loadBtn = new JButton("Load Referrals");

        createBtn.addActionListener(e -> createReferral());
        completeBtn.addActionListener(e -> completeReferral());
        loadBtn.addActionListener(e -> loadReferrals());

        JPanel top = new JPanel();
        top.add(createBtn);
        top.add(completeBtn);
        top.add(loadBtn);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void createReferral() {

        JTextField patientId = new JTextField();
        JTextField from = new JTextField("GP Surgery");
        JTextField to = new JTextField("City Hospital");
        JTextField urgency = new JTextField("High");
        JTextArea summary = new JTextArea(3, 20);

        Object[] form = {
            "Patient ID:", patientId,
            "From:", from,
            "To:", to,
            "Urgency:", urgency,
            "Summary:", new JScrollPane(summary)
        };

        int result = JOptionPane.showConfirmDialog(
            this, form, "Create Referral", JOptionPane.OK_CANCEL_OPTION
        );

        if (result != JOptionPane.OK_OPTION) return;

        Referral referral = new Referral(
            "R" + System.currentTimeMillis(),
            patientId.getText(),
            from.getText(),
            to.getText(),
            urgency.getText(),
            summary.getText(),
            "ACTIVE"
        );

        boolean created = controller.createReferral(referral);

        if (!created) {
            JOptionPane.showMessageDialog(this,
                "Only ONE active referral allowed!",
                "Error", JOptionPane.ERROR_MESSAGE);
        }

        loadReferrals();
    }

    private void completeReferral() {
        controller.completeReferral();
        loadReferrals();
    }

    private void loadReferrals() {
        model.setRowCount(0);
        List<Referral> list = controller.getReferrals();

        for (Referral r : list) {
            model.addRow(new Object[]{
                r.getReferralId(),
                r.getPatientId(),
                r.getFromFacility(),
                r.getToFacility(),
                r.getUrgency(),
                r.getClinicalSummary(),
                r.getStatus()
            });
        }
    }
}
