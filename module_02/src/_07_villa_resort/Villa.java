package _07_villa_resort;
//-	Riêng Villa sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác, Diện tích hồ bơi, Số tầng
public class Villa extends Services{
    private String standarRoom;
    private String ortherDescripton;
    private double areaPool;
    private int numberOfFloor;
    public Villa(){

    };


    public Villa(String id, String serviceName, double areUse, double rentCost, int numberOfPeoples, String typeRent, String standarRoom, String ortherDescripton, double areaPool, int numberOfFloor) {
        super(id, serviceName, areUse, rentCost, numberOfPeoples, typeRent);
        this.standarRoom = standarRoom;
        this.ortherDescripton = ortherDescripton;
        this.areaPool = areaPool;
        this.numberOfFloor = numberOfFloor;
    }

    public String getStandarRoom() {
        return standarRoom;
    }

    public void setStandarRoom(String standarRoom) {
        this.standarRoom = standarRoom;
    }

    public String getOrtherDescripton() {
        return ortherDescripton;
    }

    public void setOrtherDescripton(String ortherDescripton) {
        this.ortherDescripton = ortherDescripton;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standarRoom='" + standarRoom + '\'' +
                ", ortherDescripton='" + ortherDescripton + '\'' +
                ", areaPool=" + areaPool +
                ", numberOfFloor=" + numberOfFloor +
                '}'+super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());

    }
}
