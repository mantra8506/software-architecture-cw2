package controller;

import model.Referral;
import singleton.ReferralManager;

public class ReferralController {

    private ReferralManager referralManager;

    public ReferralController() {
        this.referralManager = ReferralManager.getInstance();
    }

    // Business logic: create referral
    public void createReferral(
            String referralId,
            String patientId,
            String clinicianId,
            String targetService,
            String clinicalSummary,
            String urgency
    ) {
        Referral referral = new Referral(
                referralId,
                patientId,
                clinicianId,
                targetService,
                clinicalSummary,
                urgency
        );

        referralManager.addReferral(referral);
    }
}
