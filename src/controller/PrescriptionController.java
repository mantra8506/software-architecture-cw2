package controller;

import data.PrescriptionFileHandler;
import java.util.List;
import model.Prescription;

public class PrescriptionController {
    public static List<Prescription> getAllPrescriptions() {
        return PrescriptionFileHandler.loadPrescriptions();
    }
}
