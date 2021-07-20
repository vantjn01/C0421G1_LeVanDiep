package case_study_module2.models;

public class Customer extends Person {

    private String address;              // địa chỉ
    private String species;              // loại khách

    public Customer() {
    }

    public Customer(String code, String fullName, String dateOfBirth, String gender, String CMND, String phoneNumber, String email, String address, String species) {
        super(code, fullName, dateOfBirth, gender, CMND, phoneNumber, email);
        this.address = address;
        this.species = species;
    }

    public Customer(String address, String species) {
        this.address = address;
        this.species = species;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", species='" + species + '\'' +
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
