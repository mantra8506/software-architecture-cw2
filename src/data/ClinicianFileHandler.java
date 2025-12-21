package data;

import model.Clinician;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ClinicianFileHandler {

    private static final String FILE_PATH = "datafiles/clinicians.csv";

    public static List<Clinician> loadClinicians() {
        List<Clinician> clinicians = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String clinicianId = values[0];
                String name = values[1];
                String specialty = values[2];
                String workplace = values[3];

                Clinician clinician = new Clinician(
                        clinicianId,
                        name,
                        specialty,
                        workplace
                );

                clinicians.add(clinician);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clinicians;
    }
}
