package ketthucmodule2.controller;

import case_study_module2.controllers.*;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    static Scanner input = new Scanner(System.in);

    public static void displayMainMenu() throws IOException {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM-----");
        System.out.print("CHỌN CHỨC NĂNG THEO SỐ ĐỂ LỰA CHỌN: ");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Xóa sản phẩm");
        System.out.println("3. Xem danh sách sản phẩm ");
        System.out.println("4. Sửa sản phẩm");
        System.out.println("5. Thoát");
        System.out.println("------------------------------");

        String choose = input.nextLine();
        while (true) {

            switch (choose) {
                case "1": {
                    System.out.println("Sản phẩm nhập khẩu");
                    EmployeeManagement.EmployeeManagement();
                    break;
                }
                case "2": {
                    System.out.println("Sản phẩm xuất khẩu");
                    CustomerManagement.CustomerManagement();
                    break;
                }

                case "3": {
                    System.exit(1);
                    break;
                }
                default: {
                    System.out.println("Chọn sai. Vui lòng chọn lại để tiếp tục.");
                    System.out.print("lựa chọn của bạn: ");
                    input.nextLine();
                    displayMainMenu();
                }
            }
        }
//    public static void employee_management(){
//        System.out.println("---------- Employee Management ----------");
//        System.out.println("1. Display list employees");
//        System.out.println("2. Add new employee");
//        System.out.println("3. Edit employee ");
//        System.out.println("4. Return main menu");
//        System.out.println("5. Exit");
//        System.out.println("------------------------------");

//    }
//    public static void customer_management(){
//        System.out.println("---------- Customer Management ----------");
//        System.out.println("1. Display list customers");
//        System.out.println("2. Add new customer");
//        System.out.println("3. Edit customer ");
//        System.out.println("4. Return main menu");
//        System.out.println("5. Exit");
//        System.out.println("------------------------------");
//
//    }
//    public static void facility_management(){
//        System.out.println("---------- Facility Management ----------");
//        System.out.println("1. Display list facility");
//        System.out.println("2. Add new facility");
//        System.out.println("3. Display list facility maintenance ");
//        System.out.println("4. Return main menu");
//        System.out.println("5. Exit");
//        System.out.println("------------------------------");
//
//    }
//    public static void booking_management(){
//        System.out.println("---------- Booking Management ----------");
//        System.out.println("1. Add new booking");
//        System.out.println("2. Display list booking");
//        System.out.println("3. Create new constracts ");
//        System.out.println("4. Display list contracts");
//        System.out.println("5. Edit contracts");
//        System.out.println("6. Return main menu");
//        System.out.println("------------------------------");
//
//    }
//    public static void promotion_management(){
//        System.out.println("---------- Promotion Management ----------");
//        System.out.println("1. Display list customers use service");
//        System.out.println("2. Display list customers get voucher");
//        System.out.println("3. Return main menu");
//        System.out.println("4. Exit");
//        System.out.println("------------------------------");
//
//    }
    }
}
