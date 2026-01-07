package controller;

import data.PatientFileHandler;
import java.util.List;
import model.Patient;

public class PatientController {

    private List<Patient> patients;

    public PatientController() {
        patients = PatientFileHandler.loadPatients();
    }

    // GET ALL
    public List<Patient> getAllPatients() {
        return patients;
    }

    // ADD
    public void addPatient(Patient p) {
        patients.add(p);
    }

    // DELETE
    public void deletePatient(int index) {
        if (index >= 0 && index < patients.size()) {
            patients.remove(index);
        }
    }

    // EDIT
    public void updatePatient(int index, Patient updated) {
        if (index >= 0 && index < patients.size()) {
            patients.set(index, updated);
        }
    }
}
