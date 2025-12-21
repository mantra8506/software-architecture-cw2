package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Prescription;

public class PrescriptionFileHandler {

    private static final String FILE_PATH = "datafiles/prescriptions.csv";

    public static List<Prescription> loadPrescriptions() {

        List<Prescription> prescriptions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            br.readLine(); // skip CSV header

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                // SAFETY CHECK (prevents blank / broken rows)
                if (values.length < 13) {
                    continue;
                }

                // Correct mapping based on university CSV
                String prescriptionId = values[0];
                String medication = values[5];      // medication_name
                String dosage = values[6];          // dosage
                String pharmacy = values[11];       // pharmacy_name
                boolean collected = values[12].equalsIgnoreCase("Collected");

                Prescription prescription = new Prescription(
                        prescriptionId,
                        medication,
                        dosage,
                        pharmacy,
                        collected
                );

                prescriptions.add(prescription);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prescriptions;
    }
}
