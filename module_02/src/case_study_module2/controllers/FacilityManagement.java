package case_study_module2.controllers;

import case_study_module2.services.task2.FacilityServicesImpl;

import java.io.IOException;
import java.util.Scanner;

public class FacilityManagement {
    public static void FacilityManagement() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Facility Management ----------");
        System.out.println("1. Display list facility");
        System.out.println("2. Add new facility");
        System.out.println("3. Display list facility maintenance ");
        System.out.println("4. Return main menu");
        System.out.println("5. Exit");
        System.out.println("------------------------------");

        int input = scanner.nextInt();
        switch (input) {
            case 1:{
//                System.out.println("1. Display list facility");
                new FacilityServicesImpl().displayList();
                break;
            }
            case 2:{
//                System.out.println("2. Add new facility");
                new FacilityServicesImpl().addNew();
                break;
            }
            case 3:{
//                System.out.println("3. Display list facility maintenance");
                new FacilityServicesImpl().displayListMaintenance();
                break;
            }
            case 4:{
                System.out.println("4. Return main menu");
                FuramaController.displayMainMenu();
                break;
            }
            case 5:{
                System.out.println("5. Exit");
                System.exit(1);
                break;

            }
            default:{
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");

            }
        }
    }

}
