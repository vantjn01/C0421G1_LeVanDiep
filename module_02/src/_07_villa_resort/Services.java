package _07_villa_resort;
//1.	Khu nghỉ dưỡng Furama sẽ cung cấp các dịch vụ cho thuê bao gồm Villa, House, Room.
//        Tất cả các dịch vụ này sẽ bao có các thông tin: Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa,
//        Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ).
//        -	Riêng Villa sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác, Diện tích hồ bơi, Số tầng.
//        -	Riêng House sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác, Số tầng.
//        -	Riêng Phòng sẽ có thêm thông tin: Dịch vụ miễn phí đi kèm.
//        Ngoài ra, resort còn cung cấp các dịch vụ đi kèm như massage, karaoke, thức ăn, nước uống, thuê xe di chuyển tham quan resort.
//        Dịch vụ đi kèm sẽ bao gồm các thông tin: Tên dịch vụ đi kèm, Đơn vị, Giá tiền

public abstract class Services {
    protected String id;
    protected String serviceName;
    protected double areUse;
    protected double rentCost;
    protected int numberOfPeoples;
    protected String typeRent;
    public Services(){

    };

    public Services(String id, String serviceName, double areUse, double rentCost, int numberOfPeoples, String typeRent) {
        this.id = id;
        this.serviceName = serviceName;
        this.areUse = areUse;
        this.rentCost = rentCost;
        this.numberOfPeoples = numberOfPeoples;
        this.typeRent = typeRent;
    }
    public abstract void showInfor();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreUse() {
        return areUse;
    }

    public void setAreUse(double areUse) {
        this.areUse = areUse;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getNumberOfPeoples() {
        return numberOfPeoples;
    }

    public void setNumberOfPeoples(int numberOfPeoples) {
        this.numberOfPeoples = numberOfPeoples;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", areUse=" + areUse +
                ", rentCost=" + rentCost +
                ", numberOfPeoples=" + numberOfPeoples +
                ", typeRent='" + typeRent + '\'' +
                '}';
    }
}
