package _07_villa_resort;
//-	Riêng Phòng sẽ có thêm thông tin: Dịch vụ miễn phí đi kèm.
public class Room extends Services{
    private ExtraService extraService;
    public Room(){

    };

    public Room(String id, String serviceName, double areUse, double rentCost, int numberOfPeoples, String typeRent, ExtraService extraService) {
        super(id, serviceName, areUse, rentCost, numberOfPeoples, typeRent);
        this.extraService = extraService;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "extraService=" + extraService +
                '}'+super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());

    }
}
