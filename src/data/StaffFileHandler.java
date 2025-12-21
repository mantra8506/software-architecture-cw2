package data;

import model.Staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StaffFileHandler {

    private static final String FILE_PATH = "datafiles/staff.csv";

    public static List<Staff> loadStaff() {
        List<Staff> staffList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String staffId = values[0];
                String name = values[1];
                String role = values[2];
                String department = values[3];

                Staff staff = new Staff(
                        staffId,
                        name,
                        role,
                        department
                );

                staffList.add(staff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return staffList;
    }
}
