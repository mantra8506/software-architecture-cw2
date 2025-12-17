package model;

public class MedicalRecord {

    private String recordId;
    private String medicalHistory;
    private String allergies;
    private String currentConditions;

    public MedicalRecord(String recordId, String medicalHistory, String allergies, String currentConditions) {
        this.recordId = recordId;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.currentConditions = currentConditions;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(String currentConditions) {
        this.currentConditions = currentConditions;
    }
}
