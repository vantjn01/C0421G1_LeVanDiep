package _07_villa_resort;
//-	Riêng House sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác, Số tầng.
public class House extends Services {
    private String standarRoom;
    private String ortherDescripton;
    private int numberOfFloor;
    public House(){

    };

    public House(String id, String serviceName, double areUse, double rentCost, int numberOfPeoples, String typeRent, String standarRoom, String ortherDescripton, int numberOfFloor) {
        super(id, serviceName, areUse, rentCost, numberOfPeoples, typeRent);
        this.standarRoom = standarRoom;
        this.ortherDescripton = ortherDescripton;
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

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "standarRoom='" + standarRoom + '\'' +
                ", ortherDescripton='" + ortherDescripton + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}'+super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());

    }

}
