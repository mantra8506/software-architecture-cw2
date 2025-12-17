package model;

public class Prescription {

    private String prescriptionId;
    private String medication;
    private String dosage;
    private String pharmacy;
    private boolean collected;

    public Prescription(String prescriptionId, String medication,
                        String dosage, String pharmacy, boolean collected) {

        this.prescriptionId = prescriptionId;
        this.medication = medication;
        this.dosage = dosage;
        this.pharmacy = pharmacy;
        this.collected = collected;
    }

    public String getMedication() {
        return medication;
    }
}
