package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.MedicalRecord;
import model.Patient;

public class PatientFileHandler {

    private static final String FILE_PATH = "datafiles/patients.csv";

    public static List<Patient> loadPatients() {

        List<Patient> patients = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            br.readLine(); // skip CSV header

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                // ✅ Safety check (VERY IMPORTANT)
                if (values.length < 5) continue;

                String patientId  = values[0];
                String name       = values[1];
                String dob        = values[2];
                String nhsNumber  = values[3];
                String contact    = values[4];

                Patient patient = new Patient(
                        patientId,
                        name,
                        dob,
                        nhsNumber,
                        contact
                );

                // ✅ Composition: Patient HAS-A MedicalRecord
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

    public static void addPatient(Patient patient) {

        try (java.io.FileWriter fw = new java.io.FileWriter(FILE_PATH, true)) {
    
            fw.write(
                patient.getPatientId() + "," +
                patient.getName() + "," +
                patient.getDateOfBirth() + "," +
                patient.getNhsNumber() + "," +
                patient.getContactDetails() + "\n"
            );
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
