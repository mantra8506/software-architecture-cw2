package controller;

import java.util.List;
import model.Referral;
import singleton.ReferralManager;

public class ReferralController {

    private ReferralManager manager = ReferralManager.getInstance();

    public boolean createReferral(Referral referral) {
        return manager.createReferral(referral);
    }

    public void completeReferral() {
        manager.completeReferral();
    }

    public List<Referral> getReferrals() {
        return manager.getAllReferrals();
    }
}
