package controller;

import model.Referral;
import singleton.ReferralManager;

public class ReferralController {

    private ReferralManager referralManager;

    public ReferralController() {
        referralManager = ReferralManager.getInstance();
    }

    public void createReferral(Referral referral) {
        referralManager.addReferral(referral);
    }
}
