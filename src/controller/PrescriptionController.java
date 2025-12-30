package controller;

import data.PrescriptionFileHandler;
import java.util.List;
import model.Prescription;

public class PrescriptionController {

    private static List<Prescription> prescriptions =
            PrescriptionFileHandler.loadPrescriptions();

    public static List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    // ADD
    public static void addPrescription(Prescription p) {
        prescriptions.add(p);
    }

    // DELETE
    public static void deletePrescription(int index) {
        if (index >= 0 && index < prescriptions.size()) {
            prescriptions.remove(index);
        }
    }
}
