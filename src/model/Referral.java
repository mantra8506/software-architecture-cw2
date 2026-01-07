package model;

public class Referral {

    private String referralId;
    private String patientId;
    private String fromFacility;
    private String toFacility;
    private String urgency;
    private String clinicalSummary;
    private String status; // ACTIVE / COMPLETED

    public Referral(String referralId,
                    String patientId,
                    String fromFacility,
                    String toFacility,
                    String urgency,
                    String clinicalSummary,
                    String status) {

        this.referralId = referralId;
        this.patientId = patientId;
        this.fromFacility = fromFacility;
        this.toFacility = toFacility;
        this.urgency = urgency;
        this.clinicalSummary = clinicalSummary;
        this.status = status;
    }

    public String getReferralId() { return referralId; }
    public String getPatientId() { return patientId; }
    public String getFromFacility() { return fromFacility; }
    public String getToFacility() { return toFacility; }
    public String getUrgency() { return urgency; }
    public String getClinicalSummary() { return clinicalSummary; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}
