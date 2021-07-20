package case_study_module2.services.task2;


import case_study_module2.models.Booking;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class BookingServicesImpl implements BookingServices{
    public static Scanner scanner = new Scanner(System.in);
    public static TreeSet<Booking> bookings = new TreeSet<>();
    static {
        Booking booking1 = new Booking("1", 10, 20, "Customer1", "villa1");
        Booking booking2 = new Booking("2", 20, 30, "Customer2", "villa2");
        bookings.add(booking1);
        bookings.add(booking2);
    }


    @Override
    public void addNew()  {

        System.out.println("nhập id Booking");
        String idBooking = scanner.nextLine();
        System.out.println("nhập ngày bắt đầu");
        int startDay = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập ngày kết thúc");
        int endDay = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập ten dich vu");
        String customer = scanner.nextLine();
        System.out.println("nhập loại dich vu");
        String facility = scanner.nextLine();
        Booking newbooking = new Booking(idBooking, startDay, endDay, customer, facility);
        bookings.add(newbooking);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayList() throws IOException {

    }


    @Override
    public void displayListBooking() {
        for (Booking bookings1 : bookings) {
                System.out.println(bookings1);
        }
    }

    @Override
    public void addNewBooking() {

    }

}
