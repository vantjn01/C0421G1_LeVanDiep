package case_study_module2.models;

public class Villa extends Facility {
    private String standardRoom;        // tiêu chuẩn phòng
    private int areaPool;            // Dtich hồ bơi
    private int floorVilla;             // Số tầng

    public Villa() {
    }

    public Villa(String name, double areaUsed, int rentCost, int maxPeople, String typeRent, String standardRoom, int areaPool, int floorVilla) {
        super(name, areaUsed, rentCost, maxPeople, typeRent);
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.floorVilla = floorVilla;
    }

    public Villa(String standardRoom, int areaPool, int floorVilla) {
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.floorVilla = floorVilla;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(int areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloorVilla() {
        return floorVilla;
    }

    public void setFloorVilla(int floorVilla) {
        this.floorVilla = floorVilla;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "name='" + name + '\'' +
                ", areaUsed=" + areaUsed +
                ", rentCost=" + rentCost +
                ", maxPeople=" + maxPeople +
                ", typeRent='" + typeRent + '\'' +
                ", standardRoom='" + standardRoom + '\'' +
                ", areaPool=" + areaPool +
                ", floorVilla=" + floorVilla +
                '}';
    }
}
