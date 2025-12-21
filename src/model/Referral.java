package model;

public class Referral {

    private String referralId;
    private String patientId;
    private String fromFacility;
    private String toFacility;
    private String urgency;
    private String clinicalSummary;

    public Referral(String referralId, String patientId,
                    String fromFacility, String toFacility,
                    String urgency, String clinicalSummary) {

        this.referralId = referralId;
        this.patientId = patientId;
        this.fromFacility = fromFacility;
        this.toFacility = toFacility;
        this.urgency = urgency;
        this.clinicalSummary = clinicalSummary;
    }

    @Override
    public String toString() {
        return "Referral ID: " + referralId + "\n" +
               "Patient ID: " + patientId + "\n" +
               "From: " + fromFacility + "\n" +
               "To: " + toFacility + "\n" +
               "Urgency: " + urgency + "\n" +
               "Summary: " + clinicalSummary;
    }
}
