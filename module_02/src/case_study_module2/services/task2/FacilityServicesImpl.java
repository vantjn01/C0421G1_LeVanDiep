package case_study_module2.services.task2;

import case_study_module2.models.Facility;
import case_study_module2.models.House;
import case_study_module2.models.Room;
import case_study_module2.models.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServicesImpl implements FacilityServices {
    static Scanner scanner = new Scanner(System.in);
    private static LinkedHashMap<Facility, Integer> myMap = new LinkedHashMap<>();

    static {
        Villa VILLA1 = new Villa("villa1", 1000, 2000, 80, "theo năm", "vip1", 100, 10);
        Villa VILLA2 = new Villa("villa2", 2000, 4000, 160, "theo năm", "vip2", 100, 10);
        House HOUSE1 = new House("house1", 100, 100, 10, "theo ngày", "vip1", 10);
        House HOUSE2 = new House("house2", 200, 200, 20, "theo ngày", "vip2", 10);
        Room ROOM1 = new Room("room1", 20, 100, 2, "theo ngày", "free");
        Room ROOM2 = new Room("room2", 40, 200, 4, "theo ngày", "free");

        myMap.put(VILLA1, 3);
        myMap.put(VILLA2, 1);
        myMap.put(HOUSE1, 3);
        myMap.put(HOUSE2, 1);
        myMap.put(ROOM1, 3);
        myMap.put(ROOM2, 1);
    }

    @Override
    public void displayList() {
        for (Map.Entry<Facility, Integer> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + "\n" + "Số lần sử dụng: " + entry.getValue());
        }
    }

    @Override
    public void addNew() {
        do {
            System.out.println("Chọn chức năng thêm : ");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            int addNewChoice = scanner.nextInt();
            switch (addNewChoice) {
                case 1:
                    System.out.println("Add New Villa.");
                    Villa newVilla = new Villa();
                    addRegularProperties(newVilla);
                    System.out.println("Nhập tiêu chuẩn phòng: ");
                    newVilla.setStandardRoom(scanner.nextLine());

                    System.out.println("Nhập diện tích hồ bơi ");
                    newVilla.setAreaPool(Integer.parseInt(scanner.nextLine()));

                    System.out.println("Nhập số tầng");
                    newVilla.setFloorVilla(Integer.parseInt(scanner.nextLine()));
                    myMap.put(newVilla, 0);
                    System.out.println("Bạn đã nhập thành công!");
                    break;

                case 2:

                    System.out.println(" Add New House.");
                    House newHouse = new House();
                    addRegularProperties(newHouse);
                    System.out.println("Nhập tiêu chuẩn phòng ");
                    newHouse.setStandardRoom(scanner.nextLine());

                    System.out.println("Nhập số tầng");
                    newHouse.setFloorHouse(Integer.parseInt(scanner.nextLine()));

                    myMap.put(newHouse, 0);
                    System.out.println("Bạn đã nhập thành công!");
                    break;

                case 3:
                    System.out.println(" Add New Room.");
                    Room newRoom = new Room();
                    addRegularProperties(newRoom);
                    System.out.println("Nhập dịch vụ miễn phí đi kèm bạn muốn: ");
                    newRoom.setFreeService(scanner.nextLine());
                    myMap.put(newRoom, 0);
                    System.out.println("Bạn đã nhập thành công!");
                    break;

                case 4:
                    return;

                default:
                    System.err.println("Vui lòng nhập lại số nguyên từ 1 đến 4,");
            }
        } while (true);
    }
    @Override
    public void displayListMaintenance() {
        System.err.println("Facilities need to maintain: ");
        for (Map.Entry<Facility, Integer> entry : myMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey().getName() + ", Số lần sử dụng: " + entry.getValue());
            }
        }
    }


    public void addRegularProperties(Facility f) {

        System.out.println("Nhập tên dịch vụ bạn muốn ");
        f.setName(scanner.nextLine());

        System.out.println("Nhập diện tích sử dụng: ");
        f.setAreaUsed(Integer.parseInt(scanner.nextLine()));

        System.out.println("Nhập chi phí thuê: ");
        f.setRentCost(Integer.parseInt(scanner.nextLine()));

        System.out.println("Nhập số lượng người tối đa ");
        f.setMaxPeople(Integer.parseInt(scanner.nextLine()));

        System.out.println("Nhập kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ) : ");
        f.setTypeRent(scanner.nextLine());
    }




    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


