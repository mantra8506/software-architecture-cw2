package model;

public class Facility {

    private String facilityId;
    private String name;
    private String type;
    private String contactInfo;
    private int capacity;

    public Facility(String facilityId, String name, String type,
                    String contactInfo, int capacity) {
        this.facilityId = facilityId;
        this.name = name;
        this.type = type;
        this.contactInfo = contactInfo;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }
}

