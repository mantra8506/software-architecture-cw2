package model;

public class Prescription {

    private String prescriptionId;
    private String medication;
    private String dosage;
    private String pharmacy;
    private boolean collected;

    public Prescription(String prescriptionId,
                        String medication,
                        String dosage,
                        String pharmacy,
                        boolean collected) {
        this.prescriptionId = prescriptionId;
        this.medication = medication;
        this.dosage = dosage;
        this.pharmacy = pharmacy;
        this.collected = collected;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getMedication() {
        return medication;
    }

    // ✅ THIS METHOD WAS MISSING — THIS IS THE FIX
    public String getDosage() {
        return dosage;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public boolean isCollected() {
        return collected;
    }
}
