package case_study_module2.models;

public class House extends Facility {
    private String standardRoom;
    private int floorHouse;

    public House() {
    }

    public House(String name, double areaUsed, int rentCost, int maxPeople, String typeRent, String standardRoom, int floorHouse) {
        super(name, areaUsed, rentCost, maxPeople, typeRent);
        this.standardRoom = standardRoom;
        this.floorHouse = floorHouse;
    }

    public House(String standardRoom, int floorHouse) {
        this.standardRoom = standardRoom;
        this.floorHouse = floorHouse;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getFloorHouse() {
        return floorHouse;
    }

    public void setFloorHouse(int floorHouse) {
        this.floorHouse = floorHouse;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", areaUsed=" + areaUsed +
                ", rentCost=" + rentCost +
                ", maxPeople=" + maxPeople +
                ", typeRent='" + typeRent + '\'' +
                ", standardRoom='" + standardRoom + '\'' +
                ", floorHouse=" + floorHouse +
                '}';
    }
}
