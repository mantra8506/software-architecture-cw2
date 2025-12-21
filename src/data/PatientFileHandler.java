package data;

import model.Patient;
import model.MedicalRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PatientFileHandler {

    private static final String FILE_PATH = "datafiles/patients.csv";

    public static List<Patient> loadPatients() {
        List<Patient> patients = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String patientId = values[0];
                String name = values[1];
                String dob = values[2];
                String nhsNumber = values[3];
                String contact = values[4];

                Patient patient = new Patient(patientId, name, dob, nhsNumber, contact);

                // Create empty medical record (composition)
                MedicalRecord record = new MedicalRecord(
                        "MR-" + patientId,
                        "Not available",
                        "None",
                        "None"
                );
                patient.setMedicalRecord(record);

                patients.add(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return patients;
    }
}
