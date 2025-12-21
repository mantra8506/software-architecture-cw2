package controller;

import data.PatientFileHandler;
import model.Patient;

import java.util.List;

public class PatientController {

    public List<Patient> getAllPatients() {
        return PatientFileHandler.loadPatients();
    }
}
