package case_study_module2.models;

public abstract class Facility {

    protected String name;                    // tên dịch vụ
    protected double areaUsed;                // diện tích sử dụng
    protected int rentCost;                   // chi phí thuê
    protected int maxPeople;                  // số người tối đa
    protected String typeRent;                // kiểu thuê


    public Facility(String name, double areaUsed, int rentCost, int maxPeople, String typeRent) {
        this.name = name;
        this.areaUsed = areaUsed;
        this.rentCost = rentCost;
        this.maxPeople = maxPeople;
        this.typeRent = typeRent;
    }

    public Facility() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public int getRentCost() {
        return rentCost;
    }

    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "name='" + name + '\'' +
                ", areaUsed=" + areaUsed +
                ", rentCost=" + rentCost +
                ", maxPeople=" + maxPeople +
                ", typeRent='" + typeRent + '\'' +
                '}';
    }
}
