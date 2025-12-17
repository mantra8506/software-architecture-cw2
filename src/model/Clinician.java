package model;

public class Clinician {

    private String clinicianId;
    private String name;
    private String specialty;
    private String workplace;

    public Clinician(String clinicianId, String name, String specialty, String workplace) {
        this.clinicianId = clinicianId;
        this.name = name;
        this.specialty = specialty;
        this.workplace = workplace;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
}
