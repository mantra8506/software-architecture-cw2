package singleton;

import model.Referral;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReferralManager {

    // SINGLE INSTANCE (Singleton)
    private static ReferralManager instance;

    // Internal referral list (acts as referral queue)
    private List<Referral> referrals;

    // PRIVATE constructor (prevents external creation)
    private ReferralManager() {
        referrals = new ArrayList<>();
    }

    // Global access point
    public static ReferralManager getInstance() {
        if (instance == null) {
            instance = new ReferralManager();
        }
        return instance;
    }

    // Add referral to system
    public void addReferral(Referral referral) {
        referrals.add(referral);
        writeReferralToFile(referral);
    }

    // Return all referrals
    public List<Referral> getReferrals() {
        return referrals;
    }

    // Simulated email / audit log
    private void writeReferralToFile(Referral referral) {
        try (FileWriter writer = new FileWriter("datafiles/referrals_output.txt", true)) {
            writer.write(referral.toString());
            writer.write(System.lineSeparator());
            writer.write("--------------------------------------------------");
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
