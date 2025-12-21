package model;

public class Staff {

    private String staffId;
    private String name;
    private String role;
    private String department;

    public Staff(String staffId, String name, String role, String department) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.department = department;
    }

    public String getRole() {
        return role;
    }
}
