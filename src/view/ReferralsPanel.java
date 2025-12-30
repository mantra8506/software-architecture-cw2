package view;

import controller.ReferralController;
import javax.swing.*;

public class ReferralsPanel extends JPanel {

    private ReferralController referralController;

    public ReferralsPanel(ReferralController referralController) {
        this.referralController = referralController;

        JButton createButton = new JButton("Create Referral");
        JTextArea output = new JTextArea(10, 50);

        createButton.addActionListener(e -> {
            referralController.createReferral(
                    "R003",
                    "P001",
                    "C001",
                    "Cardiology",
                    "Shortness of breath",
                    "HIGH"
            );
            output.append("Referral created successfully\n");
        });

        add(createButton);
        add(new JScrollPane(output));
    }
}
