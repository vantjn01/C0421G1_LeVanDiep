package case_study_module2.models;

public class Room extends Facility {
    private String freeService;      // dịch vụ miễn phí

    public Room(String name, double areaUsed, int rentCost, int maxPeople, String typeRent, String freeService) {
        super(name, areaUsed, rentCost, maxPeople, typeRent);
        this.freeService = freeService;
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", areaUsed=" + areaUsed +
                ", rentCost=" + rentCost +
                ", maxPeople=" + maxPeople +
                ", typeRent='" + typeRent + '\'' +
                ", freeService='" + freeService + '\'' +
                '}';
    }
}
