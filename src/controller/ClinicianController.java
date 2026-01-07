package controller;

import data.ClinicianFileHandler;
import model.Clinician;
import java.util.List;

public class ClinicianController {

    public static List<Clinician> getAllClinicians() {
        return ClinicianFileHandler.loadClinicians();
    }
}
