package case_study_module2.controllers;

import case_study_module2.services.task2.EmployeeServices;
import case_study_module2.services.task2.EmployeeServicesImpl;

import java.io.IOException;
import java.util.Scanner;



public class EmployeeManagement {
    public static void EmployeeManagement() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee ");
        System.out.println("4. Return main menu");
        System.out.println("5. Exit");
        System.out.println("------------------------------");
        int input = scanner.nextInt();
        boolean check = true;
        switch (input){
            case 1: {
//                System.out.println("1. Display list employees");
                new EmployeeServicesImpl().displayList();
                break;
            }
            case 2:{
//                System.out.println("2. Add new employee");
                new EmployeeServicesImpl().addNew();
                break;
            }
            case 3:{
//                System.out.println("3. Edit employee");
                new EmployeeServicesImpl().editEmployee();
                break;
            }
            case 4:{
                System.out.println("4. Return main menu");
                FuramaController.displayMainMenu();
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
