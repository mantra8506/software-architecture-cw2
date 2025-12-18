import data.FacilityFileHandler;
import model.Facility;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Facility> facilities = FacilityFileHandler.loadFacilities();

        for (Facility f : facilities) {
            System.out.println(f.getName() + " - Capacity: " + f.getCapacity());
        }
    }
}
