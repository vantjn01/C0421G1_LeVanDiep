package case_study_module2.models;

public class Employee extends Person {
    private String location;           // vị trí
    private int salary;             // lương
    private String level;              // cấp bậc, trình độ

    public Employee() {
    }

    public Employee(String code, String fullName, String dateOfBirth, String gender, String CMND, String phoneNumber, String email, String location, int salary, String level) {
        super(code, fullName, dateOfBirth, gender, CMND, phoneNumber, email);
        this.location = location;
        this.salary = salary;
        this.level = level;
    }

    public Employee(String location, int salary, String level) {
        this.location = location;
        this.salary = salary;
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "location='" + location + '\'' +
                ", salary=" + salary +
                ", level='" + level + '\'' +
                ", code='" + code + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", CMND='" + CMND + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
