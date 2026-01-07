package singleton;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import model.Referral;

public class ReferralManager {

    private static ReferralManager instance;

    private Referral activeReferral; // ONLY ONE
    private List<Referral> allReferrals = new ArrayList<>();

    private static final String OUTPUT_FILE = "datafiles/created_referrals.csv";

    private ReferralManager() {}

    public static ReferralManager getInstance() {
        if (instance == null) {
            instance = new ReferralManager();
        }
        return instance;
    }

    // CREATE (Singleton rule enforced)
    public boolean createReferral(Referral referral) {

        if (activeReferral != null) {
            return false; // ❌ block duplicate
        }

        activeReferral = referral;
        allReferrals.add(referral);
        saveToCSV(referral);
        return true;
    }

    // COMPLETE
    public void completeReferral() {
        if (activeReferral != null) {
            activeReferral.setStatus("COMPLETED");
            activeReferral = null;
        }
    }

    public List<Referral> getAllReferrals() {
        return allReferrals;
    }

    private void saveToCSV(Referral r) {
        try (FileWriter fw = new FileWriter(OUTPUT_FILE, true)) {
            fw.write(
                r.getReferralId() + "," +
                r.getPatientId() + "," +
                r.getFromFacility() + "," +
                r.getToFacility() + "," +
                r.getUrgency() + "," +
                r.getClinicalSummary().replace(",", " ") + "," +
                r.getStatus() + "\n"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
