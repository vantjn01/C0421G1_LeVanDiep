package case_study_module2.controllers;

import case_study_module2.services.task2.BookingServicesImpl;

import java.io.IOException;
import java.util.Scanner;

public class BookingManagement {
    public static void bookingFunction() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Booking Management ----------");
        System.out.println("1. Add new booking");
        System.out.println("2. Display list booking");
        System.out.println("3. Create new contracts ");
        System.out.println("4. Display list contracts");
        System.out.println("5. Edit contracts");
        System.out.println("6. Return main menu");
        System.out.println("------------------------------");
        int input = scanner.nextInt();
        switch (input){
            case 1:{
//                System.out.println("1. Add new booking");
                new BookingServicesImpl().addNew();
                break;
            }
            case 2:{
//                System.out.println("2. Display list booking");
                new BookingServicesImpl().displayListBooking();
                break;
            }
            case 3:{
                System.out.println("3. Create new contracts");
                break;
            }
            case 4:{
                System.out.println("4. Display list contracts");
                break;
            }
            case 5:{
                System.out.println("5. Edit contracts");
                break;
            }
            case 6:{
                System.out.println("6. Return main menu");
                FuramaController.displayMainMenu();
                break;
            }
            default:{
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");
            }
        }
    }
}
