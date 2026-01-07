package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Referral;

public class ReferralFileHandler {

    private static final String FILE_PATH = "datafiles/referrals.csv";

    public static List<Referral> loadExistingReferrals() {

        List<Referral> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] v = line.split(",");

                if (v.length < 6) continue; // safety

                Referral referral = new Referral(
                        v[0], // referral_id
                        v[1], // patient_id
                        v[2], // from_facility
                        v[3], // to_facility
                        v[4], // urgency
                        v[5]  // clinical_summary
                        , line
                );

                list.add(referral);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
