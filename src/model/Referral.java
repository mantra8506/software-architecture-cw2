package model;

public class Referral {

    private String referralId;
    private String clinicalSummary;
    private String urgencyLevel;

    public Referral(String referralId, String clinicalSummary, String urgencyLevel) {
        this.referralId = referralId;
        this.clinicalSummary = clinicalSummary;
        this.urgencyLevel = urgencyLevel;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }
}
