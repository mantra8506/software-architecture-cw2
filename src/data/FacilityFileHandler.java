package data;

import model.Facility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FacilityFileHandler {

    private static final String FILE_PATH = "datafiles/facilities.csv";

    public static List<Facility> loadFacilities() {
        List<Facility> facilities = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String facilityId = values[0];
                String name = values[1];
                String type = values[2];
                String contactInfo = values[3];
                int capacity = Integer.parseInt(values[4]);

                Facility facility = new Facility(
                        facilityId,
                        name,
                        type,
                        contactInfo,
                        capacity
                );

                facilities.add(facility);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return facilities;
    }
}
