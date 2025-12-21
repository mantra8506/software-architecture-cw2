import data.StaffFileHandler;
import model.Staff;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Staff> staffList = StaffFileHandler.loadStaff();

        for (Staff s : staffList) {
            System.out.println(s.getName() + " - " + s.getRole());
        }
    }
}
