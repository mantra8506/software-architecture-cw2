package controller;

import data.PrescriptionFileHandler;
import model.Prescription;

import java.util.List;

public class PrescriptionController {

    public List<Prescription> getAllPrescriptions() {
        return PrescriptionFileHandler.loadPrescriptions();
    }
}
